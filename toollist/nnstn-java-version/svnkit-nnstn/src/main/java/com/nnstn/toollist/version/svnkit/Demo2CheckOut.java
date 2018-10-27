package com.nnstn.toollist.version.svnkit;

import java.io.File;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.wc.ISVNOptions;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

/**
 * 检出代码到本地和demo0类似
 */
public class Demo2CheckOut {
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
        ISVNOptions svnOptions = SVNWCUtil.createDefaultOptions(false);

        //创建SVNClientManager 实例
        clientManager = SVNClientManager.newInstance((DefaultSVNOptions) svnOptions, "appf", "aaa111");
        //创建工作副本目录
        File workpath = new File("d:/svndemo/");

        SVNUpdateClient updateClient = clientManager.getUpdateClient();
        
        updateClient.setIgnoreExternals(true);
        try {
			long version  = updateClient.doCheckout(svnurl, workpath, SVNRevision.HEAD, SVNRevision.HEAD, true);
			System.out.println("把版本+【"+version+"】checkout到目录"+workpath+"中");
		} catch (SVNException e) {
			e.printStackTrace();
		}
        
    }
}
