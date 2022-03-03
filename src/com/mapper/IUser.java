package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Delete;

import com.vo.MComment;
import com.vo.MFile;
import com.vo.MUser;



public interface IUser {
	//����uid������
	@Select("select upassword  from muser WHERE uid=#{uid}")
	public String selectPasswordByUid(@Param("uid") int uid);
	
	
	
	//���ٿռ�	
	@Update("update mspace set ssize=ssize-#{reducesize} WHERE suid=#{uid}")
	public void ChangeSpaceByUid(@Param("uid") int uid, @Param("reducesize") int reducesize);
	
	//���ӿռ�	
	@Update("update mspace set ssize=ssize+#{plussize} WHERE suid=#{uid}")
	public void ChangeSpacePlus(@Param("uid") int uid, @Param("plussize") int plussize);
	
	//����uid��ʣ��ռ�
	@Select("select ssize  from mspace WHERE suid=#{uid}")
	public int Remain(@Param("uid") int uid);

	//����uid����ռ�sid
	@Select("select sid  from mspace WHERE suid=#{uid}")
	public int querrysid(@Param("uid") int uid);

	//�����ļ���¼
	@Insert("INSERT INTO mfile(fname, frealname,fpath,fuid,fuptime,fsize,fdowntimes,fsid,ftid,fstate) VALUES(#{fname},#{frealname},#{fpath},#{fuid},#{fuptime},#{fsize},0,#{fsid},#{ftid},0);")
	public void ChangeFile(@Param("fname") String fname, @Param("frealname") String frealname, @Param("fpath") String fpath,
                           @Param("fuid") int fuid, @Param("fuptime") String fuptime, @Param("fsize") int fsize, @Param("fsid") int fsid, @Param("ftid") int ftid);



	//�������ļ�������ʣ��ռ�ͽ����ţ�
	@Select("select *  from mfile order by fdowntimes DESC")
	public List<MFile> QuerryAllFile();

	//����
	@Update("UPDATE mfile SET fstate=0 WHERE fid=#{fid}")
	public void freeze(@Param("fid") int fid);
	
	//�ⶳ
	@Update("UPDATE mfile SET fstate=1 WHERE fid=#{fid}")
	public void NOfreeze(@Param("fid") int fid);

	//��ѯ�ļ�״̬
	@Select("select fstate  from mfile WHERE fid=#{fid}")
	public int QuerryFileState(@Param("fid") int fid);
	
	//��ѯ�ļ���С
	@Select("select fsize  from mfile WHERE fid=#{fid}")
	public int QuerryFileSize(@Param("fid") int fid);

	//�������ش���
	@Update("UPDATE mfile SET fdowntimes=fdowntimes+1 WHERE fid=#{fid}")
	public void AddDownCount(@Param("fid") String fid);


	//�������ۼ�¼
	@Insert("INSERT INTO mcomment(cuid,ccontent,cfid) VALUES (#{cuid},#{ccontent},#{cfid});")
	public void addcomment(@Param("cuid") int uid, @Param("ccontent") String acomment, @Param("cfid") int fid);


	//����������
	@Select("select *  from mcomment")
	public List<MComment> QuerryAllComments();


	//����
	@Delete("DELETE FROM mfile WHERE fid=#{fid}")
	public void mydelete(@Param("fid") int fid);
}
