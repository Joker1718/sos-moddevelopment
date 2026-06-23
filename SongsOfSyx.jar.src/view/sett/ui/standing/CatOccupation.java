/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.infra.elderly.ROOM_RESTHOME;
/*     */ import settlement.room.knowledge.school.ROOM_SCHOOL;
/*     */ import settlement.room.knowledge.university.ROOM_UNIVERSITY;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsEducation;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ class CatOccupation
/*     */   extends Cats.Cat {
/*  47 */   private static CharSequence ¤¤workPrio = "Work Priorities";
/*     */ 
/*     */   
/*     */   static {
/*  51 */     D.ts(CatOccupation.class);
/*     */   }
/*     */   
/*     */   CatOccupation(final HCLASS cl, final GETTER<Race> race) {
/*  55 */     super(new StatCollection[] { (StatCollection)STATS.WORK(), (StatCollection)STATS.EDUCATION() });
/*  56 */     titleSet(Dic.¤¤Occupation);
/*  57 */     LinkedList<RENDEROBJ> rens = new LinkedList();
/*     */ 
/*     */     
/*  60 */     rens.add(new StatRow.Title((STATS.WORK()).info));
/*  61 */     for (STAT s : (STATS.WORK()).workStats) {
/*  62 */       rens.add(new StatRow(s, cl, race));
/*     */     }
/*     */     
/*  65 */     rens.add((new GButt.ButtPanel(¤¤workPrio)
/*     */         {
/*     */           protected void clickA() {
/*  68 */             (VIEW.s()).ui.rooms.prio(cl, (Race)race.get(), (CLICKABLE)this);
/*     */           }
/*  70 */         }).pad(16, 2));
/*     */     
/*  72 */     if (cl != HCLASSES.SLAVE()) {
/*  73 */       rens.add(new StatRow((STATS.WORK()).RET.RETIREMENT_AGE, cl, race));
/*  74 */       rens.add(new StatRow((STATS.WORK()).RET.RETIREMENT_HOME, cl, race));
/*     */     } 
/*     */     
/*  77 */     if (cl == HCLASSES.CITIZEN()) {
/*     */       
/*  79 */       rens.add(new StatRow.Title((STATS.EDUCATION()).info));
/*  80 */       for (StatsEducation.StatEducation e : (STATS.EDUCATION()).all) {
/*  81 */         GButt.CheckboxSelect checkboxSelect = new GButt.CheckboxSelect()
/*     */           {
/*     */             protected void clickA()
/*     */             {
/*  85 */               STATS.EDUCATION().policySet(cl, (Race)race.get(), e);
/*  86 */               super.clickA();
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/*  91 */               selectedSet((STATS.EDUCATION().policy(cl, (Race)race.get()) == e));
/*     */             }
/*     */           };
/*     */ 
/*     */         
/*  96 */         rens.add(new StatRow(e.total, (RENDEROBJ)checkboxSelect, cl, race));
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 101 */       for (StatsEducation.AgeType aa : (STATS.EDUCATION()).allAges) {
/* 102 */         GuiSection guiSection = new GuiSection()
/*     */           {
/*     */             public void hoverInfoGet(GUI_BOX text)
/*     */             {
/* 106 */               aa.hoverLimit(text, HCLASS_RACE.clP((Race)race.get(), cl));
/*     */             }
/*     */           };
/*     */         
/* 110 */         guiSection.body().incrW(8.0D).incrH(1.0D);
/*     */         
/* 112 */         guiSection.addRightC(0, aa.icon);
/* 113 */         guiSection.addRightC(0, (RENDEROBJ)new GHeader(aa.name));
/*     */         
/* 115 */         INT.INTE ii = new INT.INTE()
/*     */           {
/*     */             public int min()
/*     */             {
/* 119 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max() {
/* 124 */               return 100;
/*     */             }
/*     */ 
/*     */             
/*     */             public int get() {
/* 129 */               return aa.limit(cl, (Race)race.get());
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 134 */               aa.limitSet(cl, (Race)race.get(), t);
/*     */             }
/*     */           };
/*     */ 
/*     */ 
/*     */         
/* 140 */         guiSection.addRightCAbs(200, (RENDEROBJ)new GSliderInt(ii, 200, true));
/* 141 */         guiSection.pad(8, 4);
/* 142 */         rens.add(guiSection);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 151 */       GuiSection s = new GuiSection();
/*     */ 
/*     */       
/* 154 */       GRows rows = new GRows(2);
/*     */       
/* 156 */       rows.add((RENDEROBJ)s);
/*     */       
/* 158 */       for (ROOM_UNIVERSITY u : (SETT.ROOMS()).UNIVERSITIES) {
/*     */         
/* 160 */         s = new GuiSection();
/*     */         
/* 162 */         s.add((SPRITE)new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 166 */                 GFORMAT.iofk(text, u.employment().employed(), u.employment().employedMax());
/*     */               }
/* 168 */             }0, 0);
/*     */ 
/*     */         
/* 171 */         s.addRelBody(8, DIR.W, (SPRITE)u.iconBig());
/* 172 */         s.body().setWidth(135.0D);
/* 173 */         s.body().pad(0, 2);
/*     */         
/* 175 */         GButt.ButtPanel b = new GButt.ButtPanel(s.asSprite())
/*     */           {
/*     */             public void hoverInfoGet(GUI_BOX box)
/*     */             {
/* 179 */               GBox b = (GBox)box;
/* 180 */               b.title(u.info.names);
/* 181 */               b.text(u.info.desc);
/* 182 */               b.NL();
/*     */               
/* 184 */               b.textLL((u.employment()).title);
/* 185 */               b.tab(6);
/* 186 */               b.add((SPRITE)GFORMAT.iofk(b.text(), u.employment().employed(), u.employment().employedMax()));
/* 187 */               b.NL();
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 194 */               (VIEW.s()).panels.add((VIEW.s()).ui.rooms.open((RoomBlueprint)u), true);
/*     */             }
/*     */           };
/* 197 */         rows.add((RENDEROBJ)b);
/*     */       } 
/*     */       
/* 200 */       rens.add((Iterable)rows.rows());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 206 */       s = new GuiSection();
/* 207 */       s.add((RENDEROBJ)new GHeader((HTYPES.CHILD()).names));
/* 208 */       s.addRightC(8, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 212 */               GFORMAT.i(text, STATS.POP().pop(HTYPES.CHILD()));
/*     */             }
/*     */           });
/* 215 */       rens.add(s);
/*     */       
/* 217 */       rows = new GRows(2);
/*     */       
/* 219 */       for (ROOM_SCHOOL u : (SETT.ROOMS()).SCHOOLS) {
/* 220 */         s = new GuiSection();
/*     */         
/* 222 */         s.addRightC(0, (SPRITE)u.iconBig());
/*     */         
/* 224 */         s.addRightC(8, (SPRITE)new GStat()
/*     */             {
/*     */               public void update(GText text)
/*     */               {
/* 228 */                 GFORMAT.percInv(text, u.service().load());
/*     */               }
/*     */             });
/*     */         
/* 232 */         s.body().setWidth(120.0D);
/* 233 */         s.body().pad(16, 0);
/*     */         
/* 235 */         GButt.ButtPanel b = new GButt.ButtPanel(s.asSprite())
/*     */           {
/*     */             public void hoverInfoGet(GUI_BOX box) {
/* 238 */               GBox b = (GBox)box;
/*     */               
/* 240 */               b.textLL(Dic.¤¤Employees);
/* 241 */               b.tab(6);
/* 242 */               b.add((SPRITE)GFORMAT.i(b.text(), u.employment().employed()));
/* 243 */               b.NL();
/*     */               
/* 245 */               b.textLL(Dic.¤¤load);
/* 246 */               b.tab(6);
/* 247 */               b.add((SPRITE)GFORMAT.perc(b.text(), u.service().load()));
/*     */               
/* 249 */               b.NL();
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 255 */               (VIEW.s()).panels.add((VIEW.s()).ui.rooms.open((RoomBlueprint)u), true);
/*     */             }
/*     */           };
/*     */         
/* 259 */         rows.add((RENDEROBJ)b);
/*     */       } 
/*     */ 
/*     */       
/* 263 */       rens.add((Iterable)rows.rows());
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 271 */     this.section.add((RENDEROBJ)(new GScrollRows((Iterable)rens, HEIGHT, 0)).view());
/*     */   }
/*     */ 
/*     */   
/*     */   GuiSection makeHomes(final HCLASS c, final GETTER<Race> race) {
/* 276 */     GuiSection s = new GuiSection();
/*     */     
/* 278 */     int i = 0;
/*     */     
/* 280 */     for (ROOM_RESTHOME hh : (SETT.ROOMS()).RESTHOMES) {
/*     */       
/* 282 */       final ROOM_RESTHOME h = hh;
/*     */ 
/*     */       
/* 285 */       SPRITE.Imp imp = new SPRITE.Imp(32)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 289 */             if (race.get() != null && ((Race)race.get()).pref().getWork(h.employment()) <= 0.0D) {
/* 290 */               OPACITY.O50.bind();
/* 291 */               COLOR.BLACK.render(r, X1, X2, Y1, Y2);
/* 292 */               OPACITY.unbind();
/*     */             } 
/* 294 */             h.iconBig().render(r, X1, X2, Y1, Y2);
/*     */           }
/*     */         };
/*     */       
/* 298 */       HOVERABLE hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 302 */             GFORMAT.iIncr(text, (h.employment().neededWorkers() - h.employment().employed()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 307 */             b.title(h.info.names);
/* 308 */             b.text(h.info.desc);
/* 309 */             b.NL(8);
/* 310 */             b.textLL((HTYPES.RETIREE()).names);
/* 311 */             b.tab(5);
/* 312 */             b.add((SPRITE)GFORMAT.iofk(b.text(), h.employment().employed(), h.employment().neededWorkers()));
/* 313 */             b.NL();
/* 314 */             b.textLL(Dic.¤¤Quality);
/* 315 */             b.tab(5);
/* 316 */             b.add((SPRITE)GFORMAT.perc(b.text(), h.quality()));
/* 317 */             b.NL();
/* 318 */             if (race.get() != null) {
/* 319 */               b.textLL(((STANDINGS.get(c)).fullfillment.info()).name);
/* 320 */               b.tab(5);
/* 321 */               b.add((SPRITE)GFORMAT.perc(b.text(), ((Race)race.get()).pref().getWork(h.employment())));
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 326 */         }).hh((SPRITE)imp);
/*     */       
/* 328 */       s.add((RENDEROBJ)hOVERABLE, 150 * i % 4, 40 * i / 4);
/* 329 */       i++;
/*     */     } 
/*     */ 
/*     */     
/* 333 */     s.pad(8);
/* 334 */     return s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatOccupation.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */