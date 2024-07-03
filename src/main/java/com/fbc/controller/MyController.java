package com.fbc.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fbc.dto.Board;
import com.fbc.dto.BundesligaDto;
import com.fbc.dto.EplRankDto;
import com.fbc.dto.LaligaRankDto;
import com.fbc.dto.Member;
import com.fbc.dto.SerieDto;
import com.fbc.mapper.BoardMapper;
import com.fbc.mapper.BundesligaMapper;
import com.fbc.mapper.EplRankMapper;
import com.fbc.mapper.LaligaRankMapper;
import com.fbc.mapper.MemberMapper;
import com.fbc.mapper.SerieMapper;

@Controller
public class MyController {
    @Autowired
    private EplRankMapper eplRankMapper;

    @Autowired
    private LaligaRankMapper laligaRankMapper;

    @Autowired
    private BundesligaMapper bundesligaMapper;

    @Autowired
    private SerieMapper serieMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private BoardMapper boardMapper;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/")
    public String root(Model model) throws IOException {
        final String url = "https://sports.news.naver.com/wfootball/index";

        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        String Euro = "#content > div > div:nth-child(5) > div.ScheduleLeagueType_match_list_container__1v4b0 > div:nth-child(1) > ul";
        final Elements euro = document.select(Euro);
        model.addAttribute("euro", euro);
        String date = "#_schedule_box > div > div.hmb_sch > span > span";
        String vs = "#_tab_box_epl";
        String eplWhere = "#_tab_btn_epl > span";
        String Left1 = "#_tab_box_epl > div > ul > li > div.vs_list.vs_list1 > div > span.name";
        String Left1Result = "#_tab_box_epl > div > ul > li > div.vs_list.vs_list1 > div > div";

        String Right1 = "#_tab_box_epl > div > ul > li > div.vs_list.vs_list2 > div > span.name";
        String Right1Result = "#_tab_box_epl > div > ul > li > div.vs_list.vs_list2 > div > div";
        String Mid1 = "#_tab_box_epl > div > ul > li > div.state > div > em";
        final Elements mid1 = document.select(Mid1);
        model.addAttribute("mid1", mid1);

        String RightDown = "#content > div > div.home_grid.home_grid2 > div.content > div.home_article";
        final Elements rightDowm = document.select(RightDown);
        model.addAttribute("rd", rightDowm);

        String ClWhere = "#_tab_group_0 > span > span";
        String Left2 = "#_tab_box_champs > div > ul > li:nth-child(1) > div.vs_list.vs_list1 > div > span.name";
        String Left2Result = "#_tab_box_champs > div > ul > li:nth-child(1) > div.vs_list.vs_list1 > div > div";
        String Mid2 = "#_tab_box_champs > div > ul > li:nth-child(1) > div.state > div > em";
        String Right2Result = "#_tab_box_champs > div > ul > li:nth-child(1) > div.vs_list.vs_list2 > div > div";
        String Right2 = "#_tab_box_champs > div > ul > li:nth-child(1) > div.vs_list.vs_list2 > div > span.name";

        String GoalRanking = "#playerRankingList_wfootball_0 > tbody";

        String Left3 = "#_tab_box_champs > div > ul > li:nth-child(2) > div.vs_list.vs_list1 > div > span.name";
        String Left3Result = "#_tab_box_champs > div > ul > li:nth-child(2) > div.vs_list.vs_list1 > div > div";
        String Mid3 = "#_tab_box_champs > div > ul > li:nth-child(2) > div.state > div > em";
        String Right3Result = "#_tab_box_champs > div > ul > li:nth-child(2) > div.vs_list.vs_list2 > div > div";
        String Right3 = "#_tab_box_champs > div > ul > li:nth-child(2) > div.vs_list.vs_list2 > div > span.name";
        final Elements left3 = document.select(Left3);
        final Elements left3Result = document.select(Left3Result);
        final Elements mid3 = document.select(Mid3);
        final Elements right3Result = document.select(Right3Result);
        final Elements right3 = document.select(Right3);
        model.addAttribute("left3", left3);
        model.addAttribute("left3Result", left3Result);
        model.addAttribute("mid3", mid3);
        model.addAttribute("right3Result", right3Result);
        model.addAttribute("right3", right3);

        final Elements dateElements = document.select(date);
        final Elements verseElements = document.select(vs);
        final Elements eplWhereElements = document.select(eplWhere);
        final Elements left1 = document.select(Left1);
        final Elements left1Result = document.select(Left1Result);
        final Elements right1 = document.select(Right1);
        final Elements right1Result = document.select(Right1Result);

        final Elements clWhere = document.select(ClWhere);
        final Elements left2 = document.select(Left2);
        final Elements left2Result = document.select(Left2Result);
        final Elements mid2 = document.select(Mid2);
        final Elements right2Result = document.select(Right2Result);
        final Elements right2 = document.select(Right2);

        final Elements goalRanking = document.select(GoalRanking);


        model.addAttribute("date", dateElements);
        model.addAttribute("verse", verseElements);
        model.addAttribute("eplwhere", eplWhereElements);
        model.addAttribute("left1", left1);
        model.addAttribute("left1Result", left1Result);
        model.addAttribute("right1", right1);
        model.addAttribute("right1Result", right1Result);
        model.addAttribute("gr", goalRanking);


        model.addAttribute("clWhere", clWhere);
        model.addAttribute("left2", left2);
        model.addAttribute("left2Result", left2Result);
        model.addAttribute("mid2", mid2);
        model.addAttribute("right2Result", right2Result);
        model.addAttribute("right2", right2);

        model.addAttribute("epl", eplRankMapper.selectEplList());


        return "root";
    }

    @GetMapping("/laligaRoot")
    public String root2(Model model) throws IOException {
        final String url = "https://sports.news.naver.com/wfootball/index";
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        String GoalRanking = "#playerRankingList_wfootball_1 > tbody";
        String date = "#_schedule_box > div > div.hmb_sch > span > span";
        String vs = "#_tab_box_primera";
        String eplWhere = "#_tab_btn_primera > span";
        String Left1 = "#_tab_box_primera > div > ul > li > div.vs_list.vs_list1 > div > span.name";
        String Left1Result = "#_tab_box_primera > div > ul > li > div.vs_list.vs_list1 > div > div";
        String Right1 = "#_tab_box_primera > div > ul > li > div.vs_list.vs_list2 > div > span.name";
        String Right1Result = "#_tab_box_primera > div > ul > li > div.vs_list.vs_list2 > div > div";
        String Mid1 = "#_tab_box_primera > div > ul > li > div.state > div > em";
        final Elements mid1 = document.select(Mid1);
        model.addAttribute("mid1", mid1);


        String ClWhere = "#_tab_group_0 > span > span";
        String Left2 = "#_tab_box_champs > div > ul > li:nth-child(1) > div.vs_list.vs_list1 > div > span.name";
        String Left2Result = "#_tab_box_champs > div > ul > li:nth-child(1) > div.vs_list.vs_list1 > div > div";
        String Mid2 = "#_tab_box_champs > div > ul > li:nth-child(1) > div.state > div > em";
        String Right2Result = "#_tab_box_champs > div > ul > li:nth-child(1) > div.vs_list.vs_list2 > div > div";
        String Right2 = "#_tab_box_champs > div > ul > li:nth-child(1) > div.vs_list.vs_list2 > div > span.name";
        String Left3 = "#_tab_box_champs > div > ul > li:nth-child(2) > div.vs_list.vs_list1 > div > span.name";
        String Left3Result = "#_tab_box_champs > div > ul > li:nth-child(2) > div.vs_list.vs_list1 > div > div";
        String Mid3 = "#_tab_box_champs > div > ul > li:nth-child(2) > div.state > div > em";
        String Right3Result = "#_tab_box_champs > div > ul > li:nth-child(2) > div.vs_list.vs_list2 > div > div";
        String Right3 = "#_tab_box_champs > div > ul > li:nth-child(2) > div.vs_list.vs_list2 > div > span.name";
        final Elements left3 = document.select(Left3);
        final Elements left3Result = document.select(Left3Result);
        final Elements mid3 = document.select(Mid3);
        final Elements right3Result = document.select(Right3Result);
        final Elements right3 = document.select(Right3);
        model.addAttribute("left3", left3);
        model.addAttribute("left3Result", left3Result);
        model.addAttribute("mid3", mid3);
        model.addAttribute("right3Result", right3Result);
        model.addAttribute("right3", right3);


        final Elements goalRanking = document.select(GoalRanking);
        final Elements dateElements = document.select(date);
        final Elements verseElements = document.select(vs);
        final Elements eplWhereElements = document.select(eplWhere);
        final Elements left1 = document.select(Left1);
        final Elements left1Result = document.select(Left1Result);
        final Elements right1 = document.select(Right1);
        final Elements right1Result = document.select(Right1Result);

        final Elements clWhere = document.select(ClWhere);
        final Elements left2 = document.select(Left2);
        final Elements left2Result = document.select(Left2Result);
        final Elements mid2 = document.select(Mid2);
        final Elements right2Result = document.select(Right2Result);
        final Elements right2 = document.select(Right2);


        model.addAttribute("gr", goalRanking);

        model.addAttribute("date", dateElements);
        model.addAttribute("verse", verseElements);
        model.addAttribute("eplwhere", eplWhereElements);
        model.addAttribute("left1", left1);
        model.addAttribute("left1Result", left1Result);
        model.addAttribute("right1", right1);
        model.addAttribute("right1Result", right1Result);

        model.addAttribute("clWhere", clWhere);
        model.addAttribute("left2", left2);
        model.addAttribute("left2Result", left2Result);
        model.addAttribute("mid2", mid2);
        model.addAttribute("right2Result", right2Result);
        model.addAttribute("right2", right2);

        model.addAttribute("epl", laligaRankMapper.selectLaligaList());

        return "root";
    }

    @GetMapping("/bundesligaRoot")
    public String root3(Model model) throws IOException {
        final String url = "https://sports.news.naver.com/wfootball/index";
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        String GoalRanking = "#playerRankingList_wfootball_2 > tbody";
        String date = "#_schedule_box > div > div.hmb_sch > span > span";
        String vs = "#_tab_box_primera";
        String eplWhere = "#_tab_btn_bundesliga > span";
        String Left1 = "#_tab_box_bundesliga > div > ul > li > div.vs_list.vs_list1 > div > span.name";
        String Left1Result = "#_tab_box_bundesliga > div > ul > li > div.vs_list.vs_list1 > div > div";
        String Right1 = "#_tab_box_bundesliga > div > ul > li > div.vs_list.vs_list2 > div > span.name";
        String Right1Result = "#_tab_box_bundesliga > div > ul > li > div.vs_list.vs_list2 > div > div";
        String Mid1 = "#_tab_box_bundesliga > div > ul > li > div.state > div > em";
        final Elements mid1 = document.select(Mid1);
        model.addAttribute("mid1", mid1);

        String ClWhere = "#_tab_group_0 > span > span";
        String Left2 = "#_tab_box_champs > div > ul > li:nth-child(1) > div.vs_list.vs_list1 > div > span.name";
        String Left2Result = "#_tab_box_champs > div > ul > li:nth-child(1) > div.vs_list.vs_list1 > div > div";
        String Mid2 = "#_tab_box_champs > div > ul > li:nth-child(1) > div.state > div > em";
        String Right2Result = "#_tab_box_champs > div > ul > li:nth-child(1) > div.vs_list.vs_list2 > div > div";
        String Right2 = "#_tab_box_champs > div > ul > li:nth-child(1) > div.vs_list.vs_list2 > div > span.name";
        String Left3 = "#_tab_box_champs > div > ul > li:nth-child(2) > div.vs_list.vs_list1 > div > span.name";
        String Left3Result = "#_tab_box_champs > div > ul > li:nth-child(2) > div.vs_list.vs_list1 > div > div";
        String Mid3 = "#_tab_box_champs > div > ul > li:nth-child(2) > div.state > div > em";
        String Right3Result = "#_tab_box_champs > div > ul > li:nth-child(2) > div.vs_list.vs_list2 > div > div";
        String Right3 = "#_tab_box_champs > div > ul > li:nth-child(2) > div.vs_list.vs_list2 > div > span.name";
        final Elements left3 = document.select(Left3);
        final Elements left3Result = document.select(Left3Result);
        final Elements mid3 = document.select(Mid3);
        final Elements right3Result = document.select(Right3Result);
        final Elements right3 = document.select(Right3);
        model.addAttribute("left3", left3);
        model.addAttribute("left3Result", left3Result);
        model.addAttribute("mid3", mid3);
        model.addAttribute("right3Result", right3Result);
        model.addAttribute("right3", right3);

        final Elements goalRanking = document.select(GoalRanking);
        final Elements dateElements = document.select(date);
        final Elements verseElements = document.select(vs);
        final Elements eplWhereElements = document.select(eplWhere);
        final Elements left1 = document.select(Left1);
        final Elements left1Result = document.select(Left1Result);
        final Elements right1 = document.select(Right1);
        final Elements right1Result = document.select(Right1Result);

        final Elements clWhere = document.select(ClWhere);
        final Elements left2 = document.select(Left2);
        final Elements left2Result = document.select(Left2Result);
        final Elements mid2 = document.select(Mid2);
        final Elements right2Result = document.select(Right2Result);
        final Elements right2 = document.select(Right2);

        model.addAttribute("gr", goalRanking);

        model.addAttribute("date", dateElements);
        model.addAttribute("verse", verseElements);
        model.addAttribute("eplwhere", eplWhereElements);
        model.addAttribute("left1", left1);
        model.addAttribute("left1Result", left1Result);
        model.addAttribute("right1", right1);
        model.addAttribute("right1Result", right1Result);

        model.addAttribute("clWhere", clWhere);
        model.addAttribute("left2", left2);
        model.addAttribute("left2Result", left2Result);
        model.addAttribute("mid2", mid2);
        model.addAttribute("right2Result", right2Result);
        model.addAttribute("right2", right2);

        model.addAttribute("epl", bundesligaMapper.selectBundesligaList());

        return "root";
    }

    @GetMapping("/serieRoot")
    public String root4(Model model) throws IOException {
        final String url = "https://sports.news.naver.com/wfootball/index";
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        String GoalRanking = "#playerRankingList_wfootball_3 > tbody";
        String date = "#_schedule_box > div > div.hmb_sch > span > span";
        String vs = "#_tab_box_primera";
        String eplWhere = "#_tab_btn_seria > span";
        String Left1 = "#_tab_box_seria > div > ul > li > div.vs_list.vs_list1 > div > span.name";
        String Left1Result = "#_tab_box_seria > div > ul > li > div.vs_list.vs_list1 > div > div";
        String Right1 = "#_tab_box_seria > div > ul > li > div.vs_list.vs_list2 > div > span.name";
        String Right1Result = "#_tab_box_seria > div > ul > li > div.vs_list.vs_list2 > div > div";
        String Mid1 = "#_tab_box_seria > div > ul > li > div.state > div > em";
        final Elements mid1 = document.select(Mid1);
        model.addAttribute("mid1", mid1);

        String ClWhere = "#_tab_group_0 > span > span";
        String Left2 = "#_tab_box_champs > div > ul > li:nth-child(1) > div.vs_list.vs_list1 > div > span.name";
        String Left2Result = "#_tab_box_champs > div > ul > li:nth-child(1) > div.vs_list.vs_list1 > div > div";
        String Mid2 = "#_tab_box_champs > div > ul > li:nth-child(1) > div.state > div > em";
        String Right2Result = "#_tab_box_champs > div > ul > li:nth-child(1) > div.vs_list.vs_list2 > div > div";
        String Right2 = "#_tab_box_champs > div > ul > li:nth-child(1) > div.vs_list.vs_list2 > div > span.name";
        String Left3 = "#_tab_box_champs > div > ul > li:nth-child(2) > div.vs_list.vs_list1 > div > span.name";
        String Left3Result = "#_tab_box_champs > div > ul > li:nth-child(2) > div.vs_list.vs_list1 > div > div";
        String Mid3 = "#_tab_box_champs > div > ul > li:nth-child(2) > div.state > div > em";
        String Right3Result = "#_tab_box_champs > div > ul > li:nth-child(2) > div.vs_list.vs_list2 > div > div";
        String Right3 = "#_tab_box_champs > div > ul > li:nth-child(2) > div.vs_list.vs_list2 > div > span.name";
        final Elements left3 = document.select(Left3);
        final Elements left3Result = document.select(Left3Result);
        final Elements mid3 = document.select(Mid3);
        final Elements right3Result = document.select(Right3Result);
        final Elements right3 = document.select(Right3);
        model.addAttribute("left3", left3);
        model.addAttribute("left3Result", left3Result);
        model.addAttribute("mid3", mid3);
        model.addAttribute("right3Result", right3Result);
        model.addAttribute("right3", right3);

        final Elements goalRanking = document.select(GoalRanking);
        final Elements dateElements = document.select(date);
        final Elements verseElements = document.select(vs);
        final Elements eplWhereElements = document.select(eplWhere);
        final Elements left1 = document.select(Left1);
        final Elements left1Result = document.select(Left1Result);
        final Elements right1 = document.select(Right1);
        final Elements right1Result = document.select(Right1Result);

        final Elements clWhere = document.select(ClWhere);
        final Elements left2 = document.select(Left2);
        final Elements left2Result = document.select(Left2Result);
        final Elements mid2 = document.select(Mid2);
        final Elements right2Result = document.select(Right2Result);
        final Elements right2 = document.select(Right2);

        model.addAttribute("gr", goalRanking);

        model.addAttribute("date", dateElements);
        model.addAttribute("verse", verseElements);
        model.addAttribute("eplwhere", eplWhereElements);
        model.addAttribute("left1", left1);
        model.addAttribute("left1Result", left1Result);
        model.addAttribute("right1", right1);
        model.addAttribute("right1Result", right1Result);

        model.addAttribute("clWhere", clWhere);
        model.addAttribute("left2", left2);
        model.addAttribute("left2Result", left2Result);
        model.addAttribute("mid2", mid2);
        model.addAttribute("right2Result", right2Result);
        model.addAttribute("right2", right2);

        model.addAttribute("epl", serieMapper.selectSerieList());

        return "root";
    }

    @GetMapping("/ranking")
    public String ranking(Model model) throws IOException {
        final String url = "https://sports.news.naver.com/wfootball/record/index?category=epl&tab=player";
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        String TopBox1 = "#content > div.record_lead > ul > li:nth-child(1)";
        String TopBox2 = "#content > div.record_lead > ul > li:nth-child(2)";
        String TopBox3 = "#content > div.record_lead > ul > li:nth-child(3)";
        String TopBox4 = "#content > div.record_lead > ul > li:nth-child(4)";
        String MidHeadBox = "#wfootballPlayerRecordBody > table > thead";
        String MidBox = "#wfootballPlayerRecordBody > table > tbody";

        final Elements topbox1 = document.select(TopBox1);
        final Elements topbox2 = document.select(TopBox2);
        final Elements topbox3 = document.select(TopBox3);
        final Elements topbox4 = document.select(TopBox4);
        final Elements midBox = document.select(MidBox);
        final Elements midHeadBox = document.select(MidHeadBox);

        model.addAttribute("tb1", topbox1);
        model.addAttribute("tb2", topbox2);
        model.addAttribute("tb3", topbox3);
        model.addAttribute("tb4", topbox4);
        model.addAttribute("mb", midBox);
        model.addAttribute("mhb", midHeadBox);


        return "ranking";
    }

    @GetMapping("/laligaRanking")
    public String laligaRanking(Model model) throws IOException {
        final String url = "https://sports.naver.com/wfootball/record/index?category=primera&tab=player";
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        String TopBox1 = "#content > div.record_lead > ul > li:nth-child(1)";
        String TopBox2 = "#content > div.record_lead > ul > li:nth-child(2)";
        String TopBox3 = "#content > div.record_lead > ul > li:nth-child(3)";
        String TopBox4 = "#content > div.record_lead > ul > li:nth-child(4)";
        String MidHeadBox = "#wfootballPlayerRecordBody > table > thead";
        String MidBox = "#wfootballPlayerRecordBody > table > tbody";

        final Elements topbox1 = document.select(TopBox1);
        final Elements topbox2 = document.select(TopBox2);
        final Elements topbox3 = document.select(TopBox3);
        final Elements topbox4 = document.select(TopBox4);
        final Elements midBox = document.select(MidBox);
        final Elements midHeadBox = document.select(MidHeadBox);

        model.addAttribute("tb1", topbox1);
        model.addAttribute("tb2", topbox2);
        model.addAttribute("tb3", topbox3);
        model.addAttribute("tb4", topbox4);
        model.addAttribute("mb", midBox);
        model.addAttribute("mhb", midHeadBox);


        return "ranking";

    }

    @GetMapping("/serieRanking")
    public String serieRanking(Model model) throws IOException {
        final String url = "https://sports.naver.com/wfootball/record/index?category=seria&tab=player";
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        String TopBox1 = "#content > div.record_lead > ul > li:nth-child(1)";
        String TopBox2 = "#content > div.record_lead > ul > li:nth-child(2)";
        String TopBox3 = "#content > div.record_lead > ul > li:nth-child(3)";
        String TopBox4 = "#content > div.record_lead > ul > li:nth-child(4)";
        String MidHeadBox = "#wfootballPlayerRecordBody > table > thead";
        String MidBox = "#wfootballPlayerRecordBody > table > tbody";

        final Elements topbox1 = document.select(TopBox1);
        final Elements topbox2 = document.select(TopBox2);
        final Elements topbox3 = document.select(TopBox3);
        final Elements topbox4 = document.select(TopBox4);
        final Elements midBox = document.select(MidBox);
        final Elements midHeadBox = document.select(MidHeadBox);

        model.addAttribute("tb1", topbox1);
        model.addAttribute("tb2", topbox2);
        model.addAttribute("tb3", topbox3);
        model.addAttribute("tb4", topbox4);
        model.addAttribute("mb", midBox);
        model.addAttribute("mhb", midHeadBox);


        return "ranking";

    }

    @GetMapping("/bundesligaRanking")
    public String bundesligaRanking(Model model) throws IOException {
        final String url = "https://sports.naver.com/wfootball/record/index?category=bundesliga&tab=player";
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();
        String TopBox1 = "#content > div.record_lead > ul > li:nth-child(1)";
        String TopBox2 = "#content > div.record_lead > ul > li:nth-child(2)";
        String TopBox3 = "#content > div.record_lead > ul > li:nth-child(3)";
        String TopBox4 = "#content > div.record_lead > ul > li:nth-child(4)";
        String MidHeadBox = "#wfootballPlayerRecordBody > table > thead";
        String MidBox = "#wfootballPlayerRecordBody > table > tbody";

        final Elements topbox1 = document.select(TopBox1);
        final Elements topbox2 = document.select(TopBox2);
        final Elements topbox3 = document.select(TopBox3);
        final Elements topbox4 = document.select(TopBox4);
        final Elements midBox = document.select(MidBox);
        final Elements midHeadBox = document.select(MidHeadBox);

        model.addAttribute("tb1", topbox1);
        model.addAttribute("tb2", topbox2);
        model.addAttribute("tb3", topbox3);
        model.addAttribute("tb4", topbox4);
        model.addAttribute("mb", midBox);
        model.addAttribute("mhb", midHeadBox);


        return "ranking";

    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("boardList", boardMapper.selectBoardList());

        return "board/list";
    }

    @GetMapping("/freeList")
    public String freeList(Model model) {
        model.addAttribute("boardList", boardMapper.selectByStatus("free"));
        return "board/list";
    }

    @GetMapping("/eplList")
    public String eplList(Model model) {
        model.addAttribute("boardList", boardMapper.selectByStatus("epl"));
        return "board/list";
    }

    @GetMapping("/laligaList")
    public String laligaList(Model model) {
        model.addAttribute("boardList", boardMapper.selectByStatus("laliga"));
        return "board/list";
    }

    @GetMapping("/bundesligaList")
    public String bundesligaList(Model model) {
        model.addAttribute("boardList", boardMapper.selectByStatus("bundesliga"));
        return "board/list";
    }

    @GetMapping("/serieList")
    public String serieList(Model model) {
        model.addAttribute("boardList", boardMapper.selectByStatus("serie"));
        return "board/list";
    }

    @GetMapping("view")
    public String view(Model model, Integer id, HttpSession httpSession) {
        String userEmail = (String) httpSession.getAttribute("email");
        if (userEmail == null) {
            return "fail/viewFail";
        }
        boardMapper.updateHits(id);
        model.addAttribute("bv", boardMapper.selectById(id));


        return "board/view";
    }

    @GetMapping("/write")
    public String write(HttpSession httpSession) {
        // 세션에서 이메일 정보를 가져옵니다.
        String userEmail = (String) httpSession.getAttribute("email");

        // 이메일 정보가 없으면 로그인되지 않은 상태이므로 실패 페이지로 이동합니다.
        if (userEmail == null) {
            return "fail/writeFail";
        }

        // 이메일 정보가 있다면 로그인된 상태이므로 글쓰기 페이지로 이동합니다.
        return "board/write";
    }

    @PostMapping("/insertList")
    public String insertList(Board board, HttpSession session) {
        String userEmail = (String) session.getAttribute("email");
        if (userEmail == null) {
            return "redirect:/fail/updateFail";
        }

        if (board.getTitle().contains(" ") || board.getContent().contains(" ")) {
            return "/fail/insertFail";
        }


        // 이메일 정보가 있다면 보드에 이메일 값을 설정합니다.
        board.setEmail(userEmail);

        // 보드를 삽입합니다.
        boardMapper.insertBoard(board);
        return "redirect:/list";

    }

    @GetMapping("/deleteList")
    public String deleteList(int id, HttpSession session) {
        String userEmail = (String) session.getAttribute("email");
        String authorEmail = boardMapper.getAuthorEmailById(id);
        if (authorEmail != null && authorEmail.equals(userEmail)){
            boardMapper.deleteList(id);
        }else{
            return "/fail/deleteFail";
        }

        return "redirect:/list";
    }

    @GetMapping("/updateList")
    public String updateList(int id,HttpSession session,Model model){
        String userEmail = (String) session.getAttribute("email");
        String authorEmail = boardMapper.getAuthorEmailById(id);
        if (authorEmail != null && authorEmail.equals(userEmail)){
            model.addAttribute("board", boardMapper.selectById(id));
                return "/board/updateListPage";
        }
        return "/fail/updateListFail";
    }

    @PostMapping("/updateListSubmit")
    public String updateListPage(Board board){
        boardMapper.updateList(board);

        return "/sucess/updateListSucess";
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/login")
    public String login() {
        return "/login/login";
    }

    @PostMapping("/signUp")
    public String signUp() {

        return "/login/signUp";
    }

    @PostMapping("/loginInsert")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        if (email == null || password == null) {
            return "redirect:/login";
        }

        Member memberUser = memberMapper.memberByEmail(email);

        if (memberUser != null && memberUser.getPassword().equals(password)) {
            session.setAttribute("email", email);

            return "redirect:/";
        } else {
            return "fail/loginFail";
        }
    }

    @PostMapping("/signUpInsert")
    public String signUpInsert(@RequestParam("email") String email, @RequestParam("password") String password,
                               @RequestParam("name") String name) {
        Member member = new Member(email, password, name); // 새로운 회원 객체 생성

        // 회원가입 로직 수행
        boolean isSuccess = performSignUp(member);

        if (isSuccess) {
            // 회원가입 성공 시 리다이렉트
            return "sucess/signUpSucess";
        } else {
            // 회원가입 실패 시 fail 페이지로 이동
            return "fail/signUpFail";
        }
    }

    // 회원가입 로직을 수행하는 메서드
    private boolean performSignUp(Member member) {
        try {
            memberMapper.insertMember(member);
            return true;
        } catch (Exception e) {
            // 회원가입 실패 시 예외 처리
            return false;
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 세션에서 사용자 정보 삭제
        session.removeAttribute("email");
        session.removeAttribute("pw");

        // 로그아웃 후 로그인 페이지로 리다이렉트
        return "sucess/logoutSucess";
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/news")
    public String news(Model model) throws IOException {
        final String url = "https://sports.news.naver.com/wfootball/index";
        Connection connection = Jsoup.connect(url);
        Document document = connection.get();

        String NewsPick = "#content > div > div.home_feature > div.feature_side > div.good_news > ol";

        final Elements newsPick = document.select(NewsPick);


        model.addAttribute("np", newsPick);
        return "news";
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/select")
    public String select() {
        return "selectTeam";
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/memberUpdateForm")
    public String memberUpdateForm(Model model, HttpSession session) {
        String email = (String) session.getAttribute("email");

        if (email != null) {
            model.addAttribute("member", memberMapper.memberByEmail(email));
            return "/updateForm/memberUpdateForm";
        } else {
            // 로그인되어 있지 않은 경우 로그인 페이지로 리다이렉트
            return "fail/updateFail";
        }
    }

    @PostMapping("/memberUpdate")
    public String memberUpdate(Member member) {
        memberMapper.updateMember(member);
        return "sucess/memberUpdateSucess";

    }
    ////////////////////////////

    @GetMapping("/updateForm")
    public String updateForm(Model model, HttpSession session) {
        String email = (String) session.getAttribute("email");

        if ("admin@admin.com".equals(email)) {
            model.addAttribute("epl", eplRankMapper.selectEplList());
            return "/updateForm/updateForm";
        } else {
            return "fail/leagueUpdateFail";
        }
    }

    @GetMapping("/laligaUpdateForm")
    public String updateForm2(Model model) {
        model.addAttribute("epl", laligaRankMapper.selectLaligaList());
        return "/updateForm/laligaUpdateForm";
    }

    @GetMapping("/bundesligaUpdateForm")
    public String updateForm3(Model model) {
        model.addAttribute("epl", bundesligaMapper.selectBundesligaList());
        return "/updateForm/bundesligaUpdateForm";
    }

    @GetMapping("/serieUpdateForm")
    public String updateForm4(Model model) {
        model.addAttribute("epl", serieMapper.selectSerieList());
        return "/updateForm/serieUpdateForm";
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/update")
    public String update(Model model, String teamName) {
        model.addAttribute("epl", eplRankMapper.selectTeamByName(teamName));
        return "/update/update";
    }

    @GetMapping("/bundesligaUpdate")
    public String update2(Model model, String teamName) {
        model.addAttribute("bundesliga", bundesligaMapper.selectTeamByName(teamName));
        return "/update/bundesligaUpdate";
    }

    @GetMapping("/laligaUpdate")
    public String update3(Model model, String teamName) {
        model.addAttribute("laliga", laligaRankMapper.selectTeamByName(teamName));
        return "/update/laligaUpdate";
    }

    @GetMapping("/serieUpdate")
    public String update4(Model model, String teamName) {
        model.addAttribute("serie", serieMapper.selectTeamByName(teamName));
        return "/update/serieUpdate";
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/realUpdate")
    public String realUpdate(EplRankDto eplRankDto) {
        eplRankMapper.updateEplForm(eplRankDto);
        return "redirect:/updateForm";
    }

    @PostMapping("/bundesligaRealUpdate")
    public String realUpdate2(BundesligaDto bundesligaDto) {
        bundesligaMapper.updateBundesligaForm(bundesligaDto);
        return "redirect:/bundesligaUpdateForm";
    }

    @PostMapping("/laligaRealUpdate")
    public String realUpdate3(LaligaRankDto laligaRankDto) {
        laligaRankMapper.updateLaligaForm(laligaRankDto);
        return "redirect:/laligaUpdateForm";
    }

    @PostMapping("/serieRealUpdate")
    public String realUpdate4(SerieDto serieDto) {
        serieMapper.updateSerieForm(serieDto);
        return "redirect:/serieUpdateForm";
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/delete")
    public String delete(String teamName) {
        eplRankMapper.delete(teamName);
        return "redirect:/updateForm";
    }

    @GetMapping("/laligaDelete")
    public String delete2(String teamName) {
        laligaRankMapper.delete(teamName);
        return "redirect:/laligaUpdateForm";
    }

    @GetMapping("/bundesligaDelete")
    public String delete3(String teamName) {
        bundesligaMapper.delete(teamName);
        return "redirect:/bundesligaUpdateForm";
    }

    @GetMapping("/serieDelete")
    public String delete4(String teamName) {
        serieMapper.delete(teamName);
        return "redirect:/serieUpdateForm";
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/insertForm")
    public String insertForm() {
        return "/insertForm/insertForm";
    }

    @GetMapping("/bundesligaInsertForm")
    public String insertForm2() {
        return "/insertForm/bundesligaInsertForm";
    }

    @GetMapping("/laligaInsertForm")
    public String insertForm3() {
        return "/insertForm/laligaInsertForm";
    }

    @GetMapping("/serieInsertForm")
    public String insertForm4() {
        return "/insertForm/serieInsertForm";
    }

    @PostMapping("/insert")
    public String insert(EplRankDto eplRankDto) {
        eplRankMapper.insertEpl(eplRankDto);
        return "redirect:/updateForm";
    }

    @PostMapping("/bundesligaInsert")
    public String insert2(BundesligaDto bundesligaDto) {
        bundesligaMapper.insertBundesliga(bundesligaDto);
        return "redirect:/bundesligaUpdateForm";
    }

    @PostMapping("/laligaInsert")
    public String insert3(LaligaRankDto laligaRankDto) {
        laligaRankMapper.insertLaliga(laligaRankDto);
        return "redirect:/laligaUpdateForm";
    }

    @PostMapping("/serieInsert")
    public String insert4(SerieDto serieDto) {
        serieMapper.insertSerie(serieDto);
        return "redirect:/serieUpdateForm";
    }
}