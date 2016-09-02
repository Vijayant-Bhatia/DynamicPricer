package com.prizy.dynamic.pricer.service.rule.nashorn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.List;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.prizy.dynamic.pricer.exception.NoRuleFoundException;
import com.prizy.dynamic.pricer.service.rule.ProductIdealPriceRule;
import com.prizy.dynamic.pricer.service.rule.ProductIdealPriceRuleImpl;

@Component
public class DynamicNashornInterpreter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicNashornInterpreter.class);

    @Value("${rule.directory}")
    private String ruleDirectory;

    @Value("${error.fileNotFound}")
    private String fileNotFoundErrorDesc;

    @Value("${error.fileRead}")
    private String fileReadErrorDesc;

    @Value("${error.noMethodFound}")
    private String methodNotFoundError;

    public BigDecimal interpretProductIdealPriceRule(List<BigDecimal> priceList) {
        String ruleFilePath = ruleDirectory + ProductIdealPriceRule.class.getSimpleName() + ".js";

        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");

        try {
            engine.eval(new FileReader(ruleFilePath));
        } catch (FileNotFoundException e) {
            LOGGER.warn(fileNotFoundErrorDesc);
            throw new NoRuleFoundException(fileNotFoundErrorDesc);
        } catch (ScriptException e) {
            LOGGER.warn(fileReadErrorDesc);
            throw new NoRuleFoundException(fileReadErrorDesc);
        }
        Invocable invocable = (Invocable) engine;

        ProductIdealPriceRule idealPriceRule = new ProductIdealPriceRuleImpl();

        BigDecimal result = null;
        try {
            result =
                    BigDecimal.valueOf((Double) invocable.invokeFunction("calculateIdealPrice", priceList,
                            idealPriceRule));
        } catch (NoSuchMethodException e) {
            LOGGER.warn(methodNotFoundError);
            throw new NoRuleFoundException(methodNotFoundError);
        } catch (ScriptException e) {
            LOGGER.warn(fileReadErrorDesc);
            throw new NoRuleFoundException(fileReadErrorDesc);
        }
        return result;
    }
}
