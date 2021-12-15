package com.sist.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private JdbcTemplate template;
	
	String sql = null;
	
	@Override
	public List<ProductDTO> getProductList() {
		
		List<ProductDTO> list = null;
		
		sql = "select * from products order by pnum desc";
		
		return list = this.template.query(sql, new RowMapper<ProductDTO>() {

			@Override
			public ProductDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				ProductDTO dto = new ProductDTO();
				dto.setPnum(rs.getInt("pnum"));
				dto.setCategory_fk(rs.getString("category_fk"));
				dto.setProducts_name(rs.getString("products_name"));
				dto.setEp_code_fk(rs.getString("ep_code_fk"));
				dto.setInput_price(rs.getInt("input_price"));
				dto.setOutput_price(rs.getInt("output_price"));
				dto.setTrans_cost(rs.getInt("trans_cost"));
				dto.setMileage(rs.getInt("mileage"));
				dto.setCompany(rs.getString("company"));
				
				return dto;
			}
		});
	}

	@Override
	public int insertProduct(ProductDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductDTO getProductCont(int pnum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProduct(ProductDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProduct(int pnum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductDTO> searchProduct(String field, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDTO> categoryList() {
		// TODO Auto-generated method stub
		return null;
	}

}
