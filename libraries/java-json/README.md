# Java JSON

- Read annotations

	+ @JsonSetter cho phép Jackson xác định tên của thuộc tính Java tương ứng với một key trong JSON

		@JsonSetter("carBrand")  
	    private String brand;
	    
	    hoặc
	    
	    @JsonSetter("name")
		public void setName(String name) {
		    this.name = name;
		}
