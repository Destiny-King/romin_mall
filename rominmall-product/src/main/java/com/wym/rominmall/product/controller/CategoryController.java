package com.wym.rominmall.product.controller;

import com.wym.common.utils.R;
import com.wym.rominmall.product.entity.CategoryEntity;
import com.wym.rominmall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


/**
 * 商品三级分类
 *
 * @author wym
 * @email wym888@gmail.com
 * @date 2022-08-11 16:02:05
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	/**
	 * 列表，查出所有分类以及子分类，以树形结构组装起来
	 */
	@RequestMapping("/list/tree")
	public R list() {
		List<CategoryEntity> entities = categoryService.listWithTree();
		return R.ok().put("data", entities);
	}


	/**
	 * 信息
	 */
	@RequestMapping("/info/{catId}")
	//@RequiresPermissions("product:category:info")
	public R info(@PathVariable("catId") Long catId) {
		CategoryEntity category = categoryService.getById(catId);

		return R.ok().put("category", category);
	}

	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("product:category:save")
	public R save(@RequestBody CategoryEntity category) {
		categoryService.save(category);

		return R.ok();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("product:category:update")
	public R update(@RequestBody CategoryEntity category) {
		categoryService.updateById(category);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("product:category:delete")
	public R delete(@RequestBody Long[] catIds) {
		categoryService.removeByIds(Arrays.asList(catIds));

		return R.ok();
	}

}
