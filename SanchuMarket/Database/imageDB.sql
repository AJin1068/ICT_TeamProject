<<<<<<< HEAD
create table image
(
 p_idx int,
 img1 varchar2(4000),
 img2 varchar2(4000),
 img3 varchar2(4000),
 img4 varchar2(4000),
 img5 varchar2(4000)
)

--fk
alter table image 
  add constraint fk_image_p_idx foreign key(p_idx)
  references product(p_idx);
  
--��ȸ
select * from image
  

  
=======
/*
--�Ǽ� ������ ���̺� �����
drop table image cascade constraints


create table image
(
	p_idx		int, 			--��ǰ��ȣ
	img1		varchar2(4000), --����1
	img2		varchar2(4000), --����2
	img3		varchar2(4000), --����3
	img4		varchar2(4000), --����4
	img5		varchar2(4000)  --����5
);

---------------------- �������� ---------------------

--------�⺻Ű(pk) ����
alter table image
	add constraint pk_image_p_idx primary key(p_idx);





*/
>>>>>>> 810e9086e2d00a49d9f25731658d776e2df5bb4f
