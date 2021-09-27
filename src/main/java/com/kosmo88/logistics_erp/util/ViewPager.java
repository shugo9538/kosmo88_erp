package com.kosmo88.logistics_erp.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ViewPager {
    private int cnt; // 글 갯수
    private int startPage; // 보여지는 시작 페이징 번호
    private int endPage; // 보여지는 마지막 페이징 번호
    private int currentPage; // 현재 페이지
    private int pageCnt; // 페이지 갯수
    private int block; // 한번에 보이는 페이지 숫자
    private int size; // 페이지 사이즈(출력 갯수)

    private int start; // 페이지 시작 번호
    private int end; // 페이지 끝 번호
    private int number; // 글 번호

    private ViewPager() {
        this.size = 10;
        this.block = 5;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
        pageCnt = (cnt / size) + (cnt % size > 0 ? 1 : 0);
    }

    public void setPageNum(int pageNum) {
        this.currentPage = pageNum;
        init();
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getNumber() {
        return number;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCnt() {
        return pageCnt;
    }

    public void setPageCnt(int pageCnt) {
        this.pageCnt = pageCnt;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCnt() {
        return cnt;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void init() {
        start = (currentPage - 1) * size + 1;
        end = (start + size) - 1;
        number = cnt - (currentPage - 1) * size;

        startPage = (currentPage / block) * block + 1;
        if (currentPage % block == 0)
            startPage -= block;

        endPage = startPage + block - 1;
        if (endPage > pageCnt)
            endPage = pageCnt;
    }

    public void setAttribute(HttpServletRequest req) {
        req.setAttribute("pageNum", getCurrentPage());
        req.setAttribute("cnt", getCnt());
        req.setAttribute("number", getNumber());

        if (cnt > 0) {
            req.setAttribute("startPage", getStartPage());
            req.setAttribute("endPage", getEndPage());
            req.setAttribute("pageBlock", getBlock());
            req.setAttribute("pageCnt", getPageCnt());
            req.setAttribute("currentPage", getCurrentPage());
        }
    }

    public void setAttribute(Model model) {
        model.addAttribute("pageNum", getCurrentPage());
        model.addAttribute("cnt", getCnt());
        model.addAttribute("number", getNumber());

        if (cnt > 0) {
            model.addAttribute("startPage", getStartPage());
            model.addAttribute("endPage", getEndPage());
            model.addAttribute("pageBlock", getBlock());
            model.addAttribute("pageCnt", getPageCnt());
            model.addAttribute("currentPage", getCurrentPage());
        }
    }
    
    public void setAttribute(ModelAndView mav) {
        mav.addObject("pageNum", getCurrentPage());
        mav.addObject("cnt", getCnt());
        mav.addObject("number", getNumber());

        if (cnt > 0) {
            mav.addObject("startPage", getStartPage());
            mav.addObject("endPage", getEndPage());
            mav.addObject("pageBlock", getBlock());
            mav.addObject("pageCnt", getPageCnt());
            mav.addObject("currentPage", getCurrentPage());
        }
    }

    public Map<String, Integer> getPageStartEnd() {
        Map<String, Integer> pageStartEnd = new HashMap<>();
        pageStartEnd.put("start", getStart());
        pageStartEnd.put("end", getEnd());
        
        return pageStartEnd;
    }
    
    public Map<String, Integer> getPageAll() {
        Map<String, Integer> pageStartEnd = new HashMap<>();
        pageStartEnd.put("start", 0);
        pageStartEnd.put("end", getCnt());
        
        return pageStartEnd;
    }
}
