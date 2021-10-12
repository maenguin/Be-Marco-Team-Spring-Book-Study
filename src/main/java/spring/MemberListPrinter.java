package spring;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class MemberListPrinter {

	@Autowired
	private MemberDao memberDao;
	@Autowired
	//maybe injected  memberPrinter2()
	private MemberPrinter mprinter;

	public MemberListPrinter() {
	}

	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.mprinter = printer;
	}

	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> mprinter.print(m));
	}

}
