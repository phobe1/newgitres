package cn.bdqn.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.bdqn.entity.Users;

@Repository("usersDao")
public class UsersDaoImpl  implements UsersDao {

	private HibernateTemplate template;

	@Autowired
	public UsersDaoImpl(@Qualifier(value="sessionFactory")SessionFactory sessionFactory) {
		this.template=new HibernateTemplate(sessionFactory);
	}


	@Override
	public Users login(Users u) {
		List<Users> list =   (List<Users>) this.template.findByValueBean(
				"from Users where username=:username and password = :password",
				u);
		System.out.println(list);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public int addUser(Users u) {
		System.out.println(u);
		return (Integer) this.template.save(u);
	}

	@Override
	public List<Users> queryList() {
		// TODO Auto-generated method stub
		return  (List<Users>) this.template.find("from Users");
	}

	@Override
	public int queryCount() {
		// TODO Auto-generated method stub
		return this.template.find("from Users").size();
	}

	@Override
	public List<Users> queryList(final int ym) {
		// setFirstResult()
		// setMaxResults()
		return this.template.execute(
				new HibernateCallback<List<Users>>() {
					@Override
					public List<Users> doInHibernate(Session session)
							throws HibernateException {
						Query query = session
								.createQuery("from Users order by id");
						query.setFirstResult((ym - 1) * 3);
						query.setMaxResults(3);
						return query.list();
					}
				});
	}

}
