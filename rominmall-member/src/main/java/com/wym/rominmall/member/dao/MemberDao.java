package com.wym.rominmall.member.dao;

import com.wym.rominmall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author wym
 * @email wym888@gmail.com
 * @date 2022-08-11 17:45:26
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
