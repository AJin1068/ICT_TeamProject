/*
--�Ǽ� ������ ���̺� �����
drop table JJim cascade constraints

create table jjim
(
	j_idx	int,		   --�������ȣ(pk)
	p_idx	int,		   --��ǰ��ȣ(fk)
	u_id	varchar2(100)  --ȸ�����̵�
)


---------------------- �������� ---------------------

--------�⺻Ű(pk) ����
alter table jjim
	add constraint pk_jjim_j_idx primary key(j_idx);

--------�ܷ�Ű(fk) ����	
--��ǰ���̺�
alter table jjim
	add constraint fk_jjim_p_idx foreign key(p_idx)
	references product(p_idx);



*/