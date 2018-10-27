package com.nnstn.toollist.version.svnkit;

import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.wc.*;

import java.io.File;

/**
 *	基础入门demo 【检出代码到本地】
 */
public class Demo0 {
    private  static SVNClientManager clientManager;

    public static void main(String[] args) {
        //  1.对版本库进行初始化
        SVNRepositoryFactoryImpl.setup();

        //访问版本库URL设置
        SVNURL svnurl = null;
        try {
            svnurl = SVNURL.parseURIEncoded("svn://172.18.232.29:9101");
        } catch (SVNException e) {
            e.printStackTrace();
        }

        //驱动选项
        ISVNOptions svnOptions = SVNWCUtil.createDefaultOptions(false);

        //创建SVNClientManager 实例
        clientManager = SVNClientManager.newInstance((DefaultSVNOptions) svnOptions, "appf", "aaa111");
        
        
        //创建工作副本目录
        File workpath = new File("d:/svntemp");
        if(!workpath.exists()){
            workpath.mkdirs();
        }else{
            System.out.println("工作副本已经存在");
        }

        //递归把工作副本检出
        SVNUpdateClient svnUpdateClient = clientManager.getUpdateClient();
        svnUpdateClient.setIgnoreExternals(false);
        try {
            svnUpdateClient.doCheckout(svnurl, workpath, SVNRevision.HEAD, SVNRevision.HEAD, SVNDepth.INFINITY, false);
        } catch (SVNException e) {
            e.printStackTrace();
        }
    }
}
