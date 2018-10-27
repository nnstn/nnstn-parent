package com.nnstn.toollist.version.svnkit;

import java.io.File;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.wc.ISVNOptions;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNCommitClient;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

/**
 * 导入目录到svn
 * 注意remote repository中不能有导入内容
 */
public class Demo1Import {
    private  static SVNClientManager clientManager;

    public static void main(String[] args) {
        //  1.对版本库进行初始化
        SVNRepositoryFactoryImpl.setup();

        //访问版本库URL设置
        SVNURL svnurl = null;
        try {
            svnurl = SVNURL.parseURIEncoded("svn://172.18.232.29:9101/test");
        } catch (SVNException e) {
            e.printStackTrace();
        }

        //驱动选项
        ISVNOptions svnOptions = SVNWCUtil.createDefaultOptions(false);

        //创建SVNClientManager 实例
        clientManager = SVNClientManager.newInstance((DefaultSVNOptions) svnOptions, "appf", "aaa111");
        //创建工作副本目录
//        File workpath = new File("d:/svntemp/test/");
        File workpath = new File("d:/redis");

        //递归把工作副本检出
        SVNCommitClient svnCommitClient = clientManager.getCommitClient();
        
        try {
        	svnCommitClient.doImport(workpath, svnurl, "目录上传",true);
        } catch (SVNException e) {
            e.printStackTrace();
        }
    }
}
