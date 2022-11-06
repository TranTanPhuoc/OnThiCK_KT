package com.clientCloud.model;

import java.util.Date;





import lombok.Data;

@Data
public class Order {
	private Long id;
	private String OrderName;
	private Double price;
	private Date ngayLap;
}
