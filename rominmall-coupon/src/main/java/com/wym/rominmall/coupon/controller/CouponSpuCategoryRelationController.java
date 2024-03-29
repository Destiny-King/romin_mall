package com.wym.rominmall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wym.rominmall.coupon.entity.CouponSpuCategoryRelationEntity;
import com.wym.rominmall.coupon.service.CouponSpuCategoryRelationService;
import com.wym.common.utils.PageUtils;
import com.wym.common.utils.R;


/**
 * 优惠券分类关联
 *
 * @author wym
 * @email wym888@gmail.com
 * @date 2022-08-11 17:35:40
 */
@RestController
@RequestMapping("coupon/couponspucategoryrelation")
public class CouponSpuCategoryRelationController {
	@Autowired
	private CouponSpuCategoryRelationService couponSpuCategoryRelationService;

	/**
     * 列表
     */
	@RequestMapping("/list")
	//@RequiresPermissions("coupon:couponspucategoryrelation:list")
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = couponSpuCategoryRelationService.queryPage(params);

		return R.ok().put("page", page);
	}


	/**
     * 信息
     */
	@RequestMapping("/info/{id}")
	//@RequiresPermissions("coupon:couponspucategoryrelation:info")
	public R info(@PathVariable("id") Long id) {
            CouponSpuCategoryRelationEntity couponSpuCategoryRelation = couponSpuCategoryRelationService.getById(id);

		return R.ok().put("couponSpuCategoryRelation", couponSpuCategoryRelation);
	}

	/**
     * 保存
     */
	@RequestMapping("/save")
	//@RequiresPermissions("coupon:couponspucategoryrelation:save")
	public R save(@RequestBody CouponSpuCategoryRelationEntity couponSpuCategoryRelation) {
            couponSpuCategoryRelationService.save(couponSpuCategoryRelation);

		return R.ok();
	}

	/**
     * 修改
     */
	@RequestMapping("/update")
	//@RequiresPermissions("coupon:couponspucategoryrelation:update")
	public R update(@RequestBody CouponSpuCategoryRelationEntity couponSpuCategoryRelation) {
            couponSpuCategoryRelationService.updateById(couponSpuCategoryRelation);

		return R.ok();
	}

	/**
     * 删除
     */
	@RequestMapping("/delete")
	//@RequiresPermissions("coupon:couponspucategoryrelation:delete")
	public R delete(@RequestBody Long[] ids) {
            couponSpuCategoryRelationService.removeByIds(Arrays.asList(ids));

		return R.ok();
	}

}
