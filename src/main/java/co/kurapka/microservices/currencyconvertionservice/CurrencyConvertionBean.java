package co.kurapka.microservices.currencyconvertionservice;

import java.math.BigDecimal;

public class CurrencyConvertionBean {

	private Long id;
	private String from;
	private String to;
	private BigDecimal quantity;
	private BigDecimal conversionMultiple;
	private BigDecimal convertedValue;
	private int port;

	public CurrencyConvertionBean() {
	}

	public CurrencyConvertionBean(Long id, String from, String to, BigDecimal quantity, BigDecimal conversionMultiple,
			BigDecimal convertedValue, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.quantity = quantity;
		this.conversionMultiple = conversionMultiple;
		this.convertedValue = convertedValue;
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public BigDecimal getConvertedValue() {
		return convertedValue;
	}

	public int getPort() {
		return port;
	}

}
