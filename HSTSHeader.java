package com.shutterfly.feature;

import com.platform.infrastructure.log.ILogCategory;
import com.platform.infrastructure.log.ServerLog;
import com.services.core.feature.FeatureCacheProxy;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.ff4j.core.Feature;

import java.io.IOException;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeatureController extends HttpServlet {

    private static final ILogCategory LOG = ServerLog.getLogCategory(FeatureController.class.getName());

    @Override
    public void init() throws ServletException {
        FeatureCacheProxy featureCacheProxy = FeatureCacheProxy.getInstance();
        featureCacheProxy.getCacheProxy().startPolling(TimeUnit.MILLISECONDS.convert(5l, TimeUnit.MINUTES));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<Feature> forkDataCollection = FeatureCacheProxy.getInstance().getAllFeatures();
        resp.getWriter().write(new ObjectMapper().writeValueAsString(forkDataCollection));
    }
}
