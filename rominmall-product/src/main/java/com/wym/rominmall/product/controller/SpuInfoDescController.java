package com.wym.rominmall.product.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wym.rominmall.product.entity.SpuInfoDescEntity;
import com.wym.rominmall.product.service.SpuInfoDescService;
import com.wym.common.utils.PageUtils;
import com.wym.common.utils.R;


/**
 * spu信息介绍
 *
 * @author wym
 * @email wym888@gmail.com
 * @date 2022-08-11 16:02:05
 */
@RestController
@RequestMapping("product/spuinfodesc")
public class SpuInfoDescController {
	@Autowired
	private SpuInfoDescService spuInfoDescService;

	/**
     * 列表
     */
	@RequestMapping("/list")
	//@RequiresPermissions("product:spuinfodesc:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = spuInfoDescService.queryPage(params);

		return R.ok().put("page", page);
	}


	/**
     * 信息
     */
	@RequestMapping("/info/{spuId}")
	//@RequiresPermissions("product:spuinfodesc:info")
	public R info(@PathVariable("spuId") Long spuId) {
            SpuInfoDescEntity spuInfoDesc = spuInfoDescService.getById(spuId);

		return R.ok().put("spuInfoDesc", spuInfoDesc);
	}

	/**
     * 保存
     */
	@RequestMapping("/save")
	//@RequiresPermissions("product:spuinfodesc:save")
	public R save(@RequestBody SpuInfoDescEntity spuInfoDesc) {
            spuInfoDescService.save(spuInfoDesc);

		return R.ok();
	}

	/**
     * 修改
     */
	@RequestMapping("/update")
	//@RequiresPermissions("product:spuinfodesc:update")
	public R update(@RequestBody SpuInfoDescEntity spuInfoDesc) {
            spuInfoDescService.updateById(spuInfoDesc);

		return R.ok();
	}

	/**
     * 删除
     */
	@RequestMapping("/delete")
	//@RequiresPermissions("product:spuinfodesc:delete")
	public R delete(@RequestBody Long[] spuIds) {
            spuInfoDescService.removeByIds(Arrays.asList(spuIds));

		return R.ok();
	}

}
