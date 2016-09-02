var calculateIdealPrice = function(priceList, idealPriceRule) {
	if (priceList == null || priceList.isEmpty()) {
	    return BigDecimal.ZERO;
	}
	var sum = 0.0;
	var size;
	var averagePrice;
	if (priceList.size() <= 4) {
		size = priceList.size()
		for(var i = 0; i < size ; i++){
			sum+=priceList[i];
		}
	    averagePrice = Math.round(sum/size * 100) / 100;
	} else {
		size = priceList.size()
		for(var i = 0; i < size ; i++){
			sum+=priceList[i];
		}
	    averagePrice = Math.round(sum/size * 100) / 100;
	}
	var idealPrice = averagePrice*1.2;
	return Math.round(idealPrice * 100) / 100;
};