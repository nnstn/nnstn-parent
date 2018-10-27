package com.nnstn.toollist.version.svnkit;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.internal.wc.DefaultSVNOptions;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNDiffClient;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class Demo5DoDiff {
    private  static SVNClientManager clientManager;

    public static void main(String[] args) {
        //  1.对版本库进行初始化
        SVNRepositoryFactoryImpl.setup();
        DefaultSVNOptions options = SVNWCUtil.createDefaultOptions(true);
        //创建SVNClientManager 实例
        clientManager = SVNClientManager.newInstance(options, "appf", "aaa111");
        
        //要提交的文件
        File difffile = new File("D:/svndemo/test/初始提交测试.txt");
        //获取SVNDiffClient类实例
        SVNDiffClient diffClient = clientManager.getDiffClient();
        try {
        	BufferedOutputStream result = new BufferedOutputStream(new FileOutputStream("d:/result.txt"));
        	diffClient.doDiff(difffile, SVNRevision.WORKING, SVNRevision.HEAD, SVNRevision.WORKING, SVNDepth.INFINITY, true, result,null);
        	
        	result.close();
        	System.out.println("对比差异输出到：d:/result.txt");
		} catch (SVNException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
    }
}
