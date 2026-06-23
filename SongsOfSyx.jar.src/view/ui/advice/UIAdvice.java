/*     */ package view.ui.advice;
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.player.PBonusSetting;
/*     */ import game.save.PROP;
/*     */ import game.save.Savable;
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.tech.TechCurrency;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.infra.admin.AdminData;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.employment.RoomEmployment;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.service.StatServiceRoom;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import snake2d.CORE;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.keymap.MAPPED;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageText;
/*     */ import view.world.generator.WorldViewGenerator;
/*     */ 
/*     */ public class UIAdvice extends GuiSection {
/*  61 */   private static CharSequence ¤¤name = "Potential Problems";
/*     */   
/*  63 */   private static CharSequence ¤¤toggleOff = "Click to suppress this warning.";
/*  64 */   private static CharSequence ¤¤toggleOn = "Click to activate this warning";
/*     */   
/*  66 */   private static CharSequence ¤¤resettle = "Resettle";
/*  67 */   private static CharSequence ¤¤resettleD = "If we find that our city is crumbling into dust, we can move to a different part of Syx and start over. We will retain our current level, and be able to unlock any new titles. We will also keep some of our resources.";
/*  68 */   private static CharSequence ¤¤resettleSure = "Are you sure you want to abandon your current city and try your luck somewhere else?";
/*     */ 
/*     */   
/*  71 */   private static CharSequence ¤¤Oddjobbers = "While oddjobbers are handy as builders and lending a hand where possible, they are essentially freeloaders, only draining your realm of resources without giving anything back. Make sure they are either contributing to your needs, or producing something to export.";
/*  72 */   private static CharSequence ¤¤OddjobbersG = "The amount of odd-jobber you have is currently not a problem.";
/*  73 */   private static CharSequence ¤¤OddjobbersB = "You have a lot of oddjobbers compared to your workforce. Give them something to do.";
/*     */   
/*  75 */   private static CharSequence ¤¤Work = "Make sure that all rooms are making the most out of their employees. If they are not properly configured, the employees will idle and be no better than oddjobbers - a drain on your economy.";
/*  76 */   private static CharSequence ¤¤WorkG = "No rooms currently have severe problems with workload.";
/*  77 */   private static CharSequence ¤¤WorkB = "Some rooms have problems with workload.";
/*     */   
/*  79 */   private static CharSequence ¤¤Resources = "Resources are meant to be used. Only a few of them are beneficial to store, like food and weapons, but only in moderate amounts. Stored resources degrade and spoil, as well as attract unwanted attention to your city. If goods can't be consumed domestically, they should be traded for something that can.";
/*  80 */   private static CharSequence ¤¤ResourcesG = "You do not currently store any goods in excess.";
/*  81 */   private static CharSequence ¤¤ResourcesB = "Some of your goods are stored excessively, currently rotting away in storage for nothing.";
/*     */   
/*  83 */   private static CharSequence ¤¤Money = "Money itself can not be eaten or utilized. It is but a temporary credit to be traded into something that is actually beneficial to your citizens. And like with resources, if horded, you are only wasting the potential of your prosperity through inflation and attracting hostile attention to your city.";
/*  84 */   private static CharSequence ¤¤MoneyG = "You currently are not hording much wealth.";
/*  85 */   private static CharSequence ¤¤MoneyB = "Your treasury is full. Piled up denarii fills no stomach. You should use it.";
/*     */   
/*  87 */   private static CharSequence ¤¤Research = "Research and technology can be just as detrimental as beneficial. It's not simply about advancing. Since technology has a perpetual cost in one form or the other, it's important to ask yourself if a technology is actually benefitting your economy, if another allocation is better, or if the resources should be diverted elsewhere.";
/*  88 */   private static CharSequence ¤¤ResearchG = "You are not spending excessive resources on technology. But remember to make sure you are getting the most out of your allocations.";
/*  89 */   private static CharSequence ¤¤ResearchB = "You have a very high ratio of research workers compared to your industry workers. This could indicate that you'd be better off reassigning some research workers to industries instead.";
/*     */   
/*  91 */   private static CharSequence ¤¤Service = "Having services always cost you resources one way or the other. As such, it's important not to over-dimension them. Remember to also go for the most rewarding services first by measuring their cost vs their benefit.";
/*  92 */   private static CharSequence ¤¤ServiceG = "Your services are properly dimensioned.";
/*  93 */   private static CharSequence ¤¤ServiceB = "Some of your services have low usage and are thus over-dimensioned";
/*     */   
/*  95 */   private static CharSequence ¤¤Nobles = "Nobles are crucial to your progress, offering big boosts to your subjects. Make sure you use all available slots and promotions.";
/*  96 */   private static CharSequence ¤¤NoblesG = "All nobles are assigned.";
/*  97 */   private static CharSequence ¤¤NoblesB = "You have free slots / promotions for nobles.";
/*     */   
/*  99 */   private static CharSequence ¤¤Trade = "You are able to trade wares att any price, but it's in your interest to buy low and sell high. You can control this by setting max or min prices in the trade panel.";
/* 100 */   private static CharSequence ¤¤TradeG = "You are trading all goods at reasonable prices";
/* 101 */   private static CharSequence ¤¤TradeB = "You are trading some goods at exorbitant prices.";
/*     */ 
/*     */   
/* 104 */   private static CharSequence ¤¤mAdvice = "Advice";
/* 105 */   private static CharSequence ¤¤mAdviceD = "You have some helpful advice to look through. It's located at the top-right portion of the city UI view.";
/*     */   
/*     */   static {
/* 108 */     D.ts(UIAdvice.class);
/*     */   }
/*     */   
/* 111 */   private final ArrayListGrower<Entry> all = new ArrayListGrower();
/*     */   
/*     */   public static boolean resettlePossible = true;
/*     */   private boolean hasOffered = false;
/*     */   private boolean hasAdvice = false;
/*     */   private static boolean silence = false;
/*     */   
/* 118 */   private static final ACTION restart = new ACTION()
/*     */     {
/*     */       
/*     */       public void exe()
/*     */       {
/* 123 */         final String race = (FACTIONS.player().race()).key;
/* 124 */         final PBonusSetting ss = (FACTIONS.player()).bonusesCustom;
/* 125 */         ss.startLevel = FACTIONS.player().level().current().index();
/*     */         
/* 127 */         for (RESOURCE res : RESOURCES.ALL()) {
/* 128 */           int am = (SETT.ROOMS()).STOCKPILE.tally().amountTotal(res) / 4;
/* 129 */           ss.startResources.set(res, am);
/*     */         } 
/*     */         
/* 132 */         final boolean a = GAME.achieving();
/*     */         
/* 134 */         CORE_STATE.Constructor c = new CORE_STATE.Constructor()
/*     */           {
/*     */             public CORE_STATE getState()
/*     */             {
/* 138 */               String[] sc = GAME.script().currentScripts();
/* 139 */               return (CORE_STATE)GAME.create(sc);
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void doAfterSet() {
/* 146 */               (FACTIONS.player()).bonusesCustom.copy(ss);
/* 147 */               GAME.achieve(a);
/* 148 */               WorldViewGenerator.setresettle((Race)RACES.map().tryGet(race));
/*     */             }
/*     */           };
/*     */ 
/*     */         
/* 153 */         CORE.setCurrentState(c);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public static GButt.ButtPanel make() {
/* 159 */     final UIAdvice a = new UIAdvice();
/* 160 */     resettlePossible = true;
/*     */     
/* 162 */     GButt.ButtPanel b = new GButt.ButtPanel((SPRITE)(UI.icons()).m.advice)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 166 */           (VIEW.inters()).popup.show((RENDEROBJ)a, (CLICKABLE)this);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 171 */           GBox b = (GBox)text;
/*     */           
/* 173 */           b.title(UIAdvice.¤¤name);
/* 174 */           for (UIAdvice.Entry e : a.all) {
/* 175 */             if (e.toggled() && 
/* 176 */               e.is()) {
/* 177 */               b.error((CharSequence)e.bad);
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 190 */           super.render(r, ds, isActive, isSelected, isHovered);
/* 191 */           if (UIAdvice.silence)
/*     */             return; 
/* 193 */           boolean has = false;
/* 194 */           for (UIAdvice.Entry e : a.all) {
/* 195 */             if (e.toggled() && e.is()) {
/*     */               
/* 197 */               OPACITY.O25TO100.bind();
/* 198 */               COLOR.REDISH.renderFrame(r, (RECTANGLE)this.body, -4, 4);
/*     */ 
/*     */ 
/*     */               
/* 202 */               OPACITY.unbind();
/* 203 */               has = true;
/*     */               break;
/*     */             } 
/*     */           } 
/* 207 */           if (has && POP.pop() > 500 && 
/* 208 */             !a.hasAdvice) {
/* 209 */             a.hasAdvice = true;
/* 210 */             (new MessageText(UIAdvice.¤¤mAdvice, UIAdvice.¤¤mAdviceD)).send();
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 216 */           UIAdvice.sendResettle(a);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 224 */     b.hoverInfoSet(¤¤name);
/* 225 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   private static void sendResettle(UIAdvice a) {
/* 230 */     if (POP.pop() < 200)
/*     */       return; 
/* 232 */     if (a.hasOffered)
/*     */       return; 
/* 234 */     double e = (STANDINGS.CITIZEN()).expectation.getD(null, 0);
/* 235 */     if (e < (STANDINGS.CITIZEN()).expectation.getD(null, 1) * 0.9D) {
/* 236 */       a.hasOffered = true;
/* 237 */       (new MessResettle()).send();
/*     */     } 
/*     */     
/* 240 */     double ee = 0.0D;
/* 241 */     for (int i = 1; i <= 4; i++) {
/* 242 */       ee += (STANDINGS.CITIZEN()).expectation.getD(null, i * 4) / 4.0D;
/*     */     }
/*     */     
/* 245 */     if (e / ee > 0.9D && e / ee < 1.1D) {
/* 246 */       a.hasOffered = true;
/* 247 */       (new MessResettle()).send();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void silence() {
/* 253 */     silence = true;
/*     */   }
/*     */ 
/*     */   
/*     */   private UIAdvice() {
/* 258 */     silence = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 507 */     ArrayList<RENDEROBJ> rows = new ArrayList<>(this.all.size() + 1);
/*     */     
/* 509 */     for (Entry e : this.all) {
/* 510 */       rows.add(e);
/*     */     }
/* 512 */     add((RENDEROBJ)(new GScrollRows(rows, 480)).view());
/*     */     
/* 514 */     addRelBody(8, DIR.N, (RENDEROBJ)new GHeader(¤¤name));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 519 */     addRelBody(8, DIR.S, (RENDEROBJ)new GButt.ButtPanel(¤¤resettle)
/*     */         {
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 524 */             text.text(UIAdvice.¤¤resettleD);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 529 */             (VIEW.inters()).yesNo.activate(UIAdvice.¤¤resettleSure, UIAdvice.restart, null, true);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 534 */             activeSet(UIAdvice.resettlePossible);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 539 */     GAME.saver().addSpecialSaver(new Savable("UI_ADVICE")
/*     */         {
/*     */           protected void save(FilePutter file)
/*     */           {
/* 543 */             file.bool(UIAdvice.this.hasAdvice);
/* 544 */             file.bool(UIAdvice.this.hasOffered);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected void load(FileGetter file) throws IOException {
/* 550 */             UIAdvice.this.hasAdvice = file.bool();
/* 551 */             UIAdvice.this.hasOffered = file.bool();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   private static abstract class Entry
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     private final CharSequence sdesc;
/*     */     private final String key;
/*     */     private final SPRITE icon;
/*     */     private final GText good;
/*     */     private final GText bad;
/* 565 */     protected double old = -1.0D;
/*     */     
/*     */     Entry(ArrayListGrower<Entry> all, SPRITE icon, CharSequence sdesc, CharSequence sgood, CharSequence sbad) {
/* 568 */       super(600, 80);
/*     */       
/* 570 */       String key = "ADVICE_" + all.size();
/* 571 */       all.add(this);
/* 572 */       this.sdesc = sdesc;
/* 573 */       this.key = key;
/* 574 */       this.icon = icon;
/*     */ 
/*     */       
/* 577 */       this.good = new GText((UI.FONT()).S, sgood);
/* 578 */       this.good.normalify2();
/* 579 */       this.good.setMaxWidth(500);
/* 580 */       this.good.setMultipleLines(true);
/*     */       
/* 582 */       this.bad = new GText((UI.FONT()).S, sbad);
/* 583 */       this.bad.errorify();
/* 584 */       this.bad.setMaxWidth(500);
/* 585 */       this.bad.setMultipleLines(true);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     abstract boolean is();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 597 */       GButt.ButtPanel.renderBG(r, true, (PROP.propI(this.key, 0) == 0), isHovered, (RECTANGLE)this.body);
/*     */       
/* 599 */       this.icon.renderC(r, this.body.x1() + 24, this.body.cY());
/*     */       
/* 601 */       GText t = is() ? this.bad : this.good;
/*     */       
/* 603 */       t.renderCY(r, this.body.x1() + 48, this.body.cY());
/*     */       
/* 605 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 611 */       PROP.propISet(this.key, PROP.propI(this.key, 0) + 1 & 0x1);
/*     */     }
/*     */     
/*     */     public boolean toggled() {
/* 615 */       return (PROP.propI(this.key, 0) == 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 620 */       GBox b = (GBox)text;
/* 621 */       b.text(this.sdesc);
/* 622 */       b.sep();
/* 623 */       CharSequence t = (PROP.propI(this.key, 0) == 0) ? UIAdvice.¤¤toggleOff : UIAdvice.¤¤toggleOn;
/* 624 */       b.warn(t);
/*     */       
/* 626 */       super.hoverInfoGet(text);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static abstract class Count<T>
/*     */   {
/*     */     boolean has = false;
/*     */     
/* 635 */     int ui = 0;
/*     */     private final LIST<T> all;
/*     */     
/*     */     Count(LIST<T> all) {
/* 639 */       this.all = all;
/*     */     }
/*     */ 
/*     */     
/*     */     boolean is() {
/* 644 */       if (GAME.updateI() == this.ui) {
/* 645 */         return this.has;
/*     */       }
/*     */       
/* 648 */       int start = this.ui;
/* 649 */       int end = GAME.updateI() & Integer.MAX_VALUE;
/* 650 */       if (end - start >= this.all.size()) {
/* 651 */         start = end - this.all.size();
/*     */       }
/* 653 */       this.ui = end;
/*     */       
/* 655 */       for (; start < end; start++) {
/* 656 */         int ei = start % this.all.size();
/* 657 */         if (ei == 0) {
/* 658 */           this.has = pis();
/* 659 */           clear();
/*     */         } 
/* 661 */         T e = (T)this.all.get(ei);
/* 662 */         count(e);
/*     */       } 
/* 664 */       return this.has;
/*     */     }
/*     */ 
/*     */     
/*     */     abstract void count(T param1T);
/*     */     
/*     */     abstract boolean pis();
/*     */     
/*     */     abstract void clear();
/*     */   }
/*     */   
/*     */   private static class MessResettle
/*     */     extends MessageSection
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     public MessResettle() {
/* 681 */       super(UIAdvice.¤¤resettle);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void make(GuiSection section) {
/* 686 */       paragraph(UIAdvice.¤¤resettleD);
/*     */       
/* 688 */       section.addRelBody(8, DIR.S, (RENDEROBJ)new GButt.ButtPanel(UIAdvice.¤¤resettle)
/*     */           {
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text)
/*     */             {
/* 693 */               text.text(UIAdvice.¤¤resettleD);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 698 */               (VIEW.inters()).yesNo.activate(UIAdvice.¤¤resettleSure, UIAdvice.restart, null, true);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 703 */               activeSet(UIAdvice.resettlePossible);
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\advice\UIAdvice.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */