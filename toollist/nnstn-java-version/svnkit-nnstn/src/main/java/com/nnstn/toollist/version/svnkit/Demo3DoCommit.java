package com.nnstn.toollist.version.svnkit;

import java.io.File;

import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.wc.ISVNOptions;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNStatus;
import org.tmatesoft.svn.core.wc.SVNStatusClient;
import org.tmatesoft.svn.core.wc.SVNStatusType;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class Demo3DoCommit {
    private  static SVNClientManager clientManager;

    public static void main(String[] args) {
        //  1.对版本库进行初始化
        SVNRepositoryFactoryImpl.setup();

        //访问版本库URL设置
        SVNURL svnurl = null;
        try {
            svnurl = SVNURL.parseURIEncoded("svn://172.18.232.29:9101/");
        } catch (SVNException e) {
            e.printStackTrace();
        }

        //驱动选项
        ISVNOptions svnOptions = SVNWCUtil.createDefaultOptions(true);

        //创建SVNClientManager 实例
        clientManager = SVNClientManager.newInstance((DefaultSVNOptions) svnOptions, "appf", "aaa111");
        
        System.out.println(clientManager.getStatusClient());
        
        //要提交的文件
        File commitfile = new File("D:/svndemo/test/初始提交测试.txt");
        //获取提交文件的状态
        SVNStatusClient statusClient = clientManager.getStatusClient();
        
        try {
			SVNStatus status = statusClient.doStatus(commitfile, false);
			System.out.println(status.getContentsStatus());
			//如果此文件是新增的则把此文件添加到版本库，然后提交
			if(status.getContentsStatus()==SVNStatusType.STATUS_NONE){
				clientManager.getWCClient().doAdd(commitfile, false, false, false, false);
				clientManager.getCommitClient().doCommit(new File[]{commitfile}, false, "add tiijao", null, null, true, false, SVNDepth.INFINITY);
				System.out.println("add");
			}else {
				//如果此文件不是新增的则直接提交
				clientManager.getCommitClient().doCommit(new File[]{commitfile}, false, "add tiijao", null, null, true, false, SVNDepth.INFINITY);
				System.out.println("commit");
			}
		} catch (SVNException e) {
			e.printStackTrace();
		}
        
        
    }
}
