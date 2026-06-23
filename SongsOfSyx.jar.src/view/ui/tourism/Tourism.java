/*     */ package view.ui.tourism;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import game.tourism.Review;
/*     */ import game.tourism.TOURISM;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GTarget;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.statistics.HISTORY_INT;
/*     */ import util.statistics.HistoryInt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.main.VIEW;
/*     */ import view.ui.wiki.WIKI;
/*     */ 
/*     */ final class Tourism extends GuiSection {
/*  42 */   int hovered = -1;
/*  43 */   private static CharSequence ¤¤goTo = "¤Go to next tourist";
/*  44 */   private static CharSequence ¤¤Permit = "¤Click to toggle permission for race to visit and sightsee in your city.";
/*  45 */   private static CharSequence ¤¤Generosity = "¤Generosity";
/*  46 */   private static CharSequence ¤¤Attractions = "¤Attracted by:";
/*     */   
/*  48 */   private static CharSequence ¤¤bad = "¤Poor";
/*  49 */   private static CharSequence ¤¤ok = "¤Mixed";
/*  50 */   private static CharSequence ¤¤good = "¤Overwhelmingly Positive";
/*     */   
/*  52 */   private static CharSequence ¤¤attracted = "¤Attracted (year)";
/*     */   
/*     */   static {
/*  55 */     D.ts(Tourism.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Tourism(int height) {
/*  61 */     stats();
/*  62 */     perm();
/*  63 */     addRelBody(16, DIR.N, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  67 */             GFORMAT.i(text, TOURISM.perYear());
/*     */           }
/*  69 */         }).hv(¤¤attracted));
/*  70 */     rev(height);
/*     */ 
/*     */ 
/*     */     
/*  74 */     pad(6, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  80 */     if (htourist() != null)
/*  81 */       SETT.OVERLAY().add((ENTITY)htourist()); 
/*  82 */     super.render(r, ds);
/*     */   }
/*     */   
/*     */   private Humanoid htourist() {
/*  86 */     if (this.hovered == -1)
/*  87 */       return null; 
/*  88 */     ENTITY e = SETT.ENTITIES().getAllEnts()[MATH.mod(this.hovered, (SETT.ENTITIES().getAllEnts()).length)];
/*  89 */     if (e != null && e instanceof Humanoid && !e.isRemoved()) {
/*  90 */       Humanoid a = (Humanoid)e;
/*  91 */       if (a.indu().hType() == HTYPES.TOURIST())
/*  92 */         return a; 
/*     */     } 
/*  94 */     this.hovered = -1;
/*  95 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private void stats() {
/* 100 */     int x1 = body().x1();
/*     */     
/* 102 */     add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 106 */             GFORMAT.i(text, STATS.POP().pop(HTYPES.TOURIST()));
/*     */           }
/* 108 */         }).increase().hh((HTYPES.TOURIST()).names));
/*     */     
/* 110 */     addRightC(100, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.crossair)
/*     */         {
/*     */           
/*     */           protected void clickA()
/*     */           {
/* 115 */             ENTITY[] all = SETT.ENTITIES().getAllEnts();
/* 116 */             int mm = Tourism.this.hovered + 1;
/* 117 */             for (int i = 1; i <= all.length; i++) {
/* 118 */               int ei = MATH.mod(i + mm, all.length);
/* 119 */               ENTITY e = all[ei];
/* 120 */               if (e instanceof Humanoid) {
/* 121 */                 Humanoid a = (Humanoid)e;
/* 122 */                 if (a.indu().hType() == HTYPES.TOURIST()) {
/* 123 */                   Tourism.this.hovered = ei;
/* 124 */                   (VIEW.UI()).manager.close();
/* 125 */                   (VIEW.s().getWindow()).centerer.set(a.body().cX(), a.body().cY());
/*     */                   return;
/*     */                 } 
/*     */               } 
/*     */             } 
/* 130 */             Tourism.this.hovered = -1;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 135 */             activeSet((STATS.POP().pop(HTYPES.TOURIST()) > 0));
/*     */           }
/* 138 */         }).hoverInfoSet(¤¤goTo));
/*     */     
/* 140 */     addRightC(8, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.questionmark)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 144 */             TOURISM.wiki().exe();
/*     */           }
/* 146 */         }).hoverInfoSet(WIKI.¤¤name));
/*     */ 
/*     */     
/* 149 */     final HISTORY_INT c = TOURISM.history();
/* 150 */     GStaples s = new GStaples(hISTORY_INT.historyRecords())
/*     */       {
/*     */         protected void hover(GBox box, int stapleI)
/*     */         {
/* 154 */           int i = c.historyRecords() - 1 - stapleI;
/* 155 */           box.textLL((CharSequence)DicTime.setSpanDays((Str)box.text(), i * c.time().bitSeconds(), (i + 1) * c.time().bitSeconds()));
/* 156 */           box.NL();
/* 157 */           box.add((SPRITE)GFORMAT.iIncr(box.text(), c.get(i)));
/*     */         }
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/* 162 */           int i = c.historyRecords() - 1 - stapleI;
/* 163 */           return c.get(i);
/*     */         }
/*     */       };
/* 166 */     s.body().setWidth(400.0D).setHeight(64.0D);
/* 167 */     add((RENDEROBJ)s, x1, body().y2() + 2);
/*     */ 
/*     */     
/* 170 */     final HistoryInt c = (FACTIONS.player().credits().get(FCredits.CTYPE.TOURISM)).IN;
/* 171 */     add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 175 */             GFORMAT.i(text, c.get(0));
/*     */           }
/* 177 */         }).increase().hh(Dic.¤¤Earnings), x1, body().y2() + 12);
/*     */     
/* 179 */     s = new GStaples(c.historyRecords())
/*     */       {
/*     */         protected void hover(GBox box, int stapleI)
/*     */         {
/* 183 */           int i = c.historyRecords() - 1 - stapleI;
/* 184 */           box.textLL((CharSequence)DicTime.setSpanDays((Str)box.text(), i * c.time().bitSeconds(), (i + 1) * c.time().bitSeconds()));
/* 185 */           box.NL();
/* 186 */           box.add((SPRITE)GFORMAT.iIncr(box.text(), c.get(i)));
/*     */         }
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/* 191 */           int i = c.historyRecords() - 1 - stapleI;
/* 192 */           return c.get(i);
/*     */         }
/*     */       };
/* 195 */     s.body().setWidth(400.0D).setHeight(64.0D);
/* 196 */     addRelBody(2, DIR.S, (RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */   
/*     */   private void perm() {
/* 201 */     int i = 0;
/* 202 */     GuiSection s = new GuiSection();
/* 203 */     for (Race r : TOURISM.races()) {
/*     */       
/* 205 */       s.addGrid((RENDEROBJ)(new GButt.ButtPanel((SPRITE)(r.appearance()).iconBig)
/*     */           {
/*     */             protected void renAction()
/*     */             {
/* 209 */               selectedSet(TOURISM.permit(r));
/*     */             }
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 214 */               TOURISM.permit(r, !TOURISM.permit(r));
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 219 */               GBox b = (GBox)text;
/* 220 */               b.title(r.info.names);
/*     */               
/* 222 */               b.textL(Dic.¤¤Occurrence);
/* 223 */               b.tab(5);
/* 224 */               b.add((SPRITE)GFORMAT.perc(b.text(), (r.tourism()).occurence));
/* 225 */               b.NL(2);
/*     */               
/* 227 */               b.textL(Tourism.¤¤Generosity);
/* 228 */               b.tab(5);
/* 229 */               b.add((SPRITE)GFORMAT.perc(b.text(), (r.tourism()).credits));
/* 230 */               b.NL(2);
/*     */ 
/*     */               
/* 233 */               b.textLL(Tourism.¤¤Attractions);
/* 234 */               b.NL();
/* 235 */               boolean line = false;
/* 236 */               for (RoomBlueprintImp p : (r.tourism()).attractions) {
/* 237 */                 b.add((SPRITE)p.iconBig());
/* 238 */                 b.text(p.info.names);
/*     */                 
/* 240 */                 if (line) {
/* 241 */                   b.NL();
/*     */                 } else {
/* 243 */                   b.tab(7);
/*     */                 } 
/* 245 */                 line = !line;
/*     */               } 
/*     */               
/* 248 */               b.NL(8);
/*     */               
/* 250 */               b.textL(Tourism.¤¤Permit);
/*     */             }
/* 254 */           }).pad(8, 2), 
/* 255 */           i++, 8, 2, 2);
/*     */     } 
/*     */ 
/*     */     
/* 259 */     addRelBody(12, DIR.S, (RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void rev(int height) {
/* 267 */     final INT.INTE in = new INT.INTE() {
/* 268 */         int i = 0;
/*     */         
/*     */         public int min() {
/* 271 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 276 */           return CLAMP.i(TOURISM.reviews().size() - 1, 0, 100);
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 281 */           return this.i;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 286 */           this.i = t;
/*     */         }
/*     */       };
/*     */     
/* 290 */     addRelBody(4, DIR.S, (RENDEROBJ)new GHeader(Dic.¤¤Reviews));
/*     */     
/* 292 */     int x1 = getLastX2();
/* 293 */     int cy = getLast().cY();
/*     */     
/* 295 */     GTarget t = new GTarget(100, null, false, true, new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 299 */             if (in.max() == 0) {
/* 300 */               GFORMAT.iofk(text, in.get(), in.max());
/*     */             } else {
/* 302 */               GFORMAT.iofk(text, (in.get() + 1), (in.max() + 1));
/* 303 */             }  text.normalify();
/*     */           }
/* 305 */         }in);
/* 306 */     addRelBody(4, DIR.S, (RENDEROBJ)t);
/*     */ 
/*     */     
/* 309 */     RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(900, height - body().height() - 16)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 313 */           Review rev = (Review)TOURISM.reviews().get(in.get());
/* 314 */           if (rev != null) {
/* 315 */             rev.render(r, body().x1(), body().y1(), body().width());
/*     */           }
/*     */         }
/*     */       };
/*     */     
/* 320 */     addRelBody(16, DIR.S, (RENDEROBJ)renderImp);
/*     */     
/* 322 */     addC((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 326 */             text.add('(');
/* 327 */             double d = TOURISM.score();
/* 328 */             if (d < 0.3D) {
/* 329 */               text.add(Tourism.¤¤bad);
/* 330 */             } else if (d < 0.8D) {
/* 331 */               text.add(Tourism.¤¤ok);
/*     */             } else {
/* 333 */               text.add(Tourism.¤¤good);
/* 334 */             }  text.add(')');
/* 335 */             text.lablifySub();
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 340 */             b.add((SPRITE)GFORMAT.perc(b.text(), TOURISM.score()));
/*     */           }
/* 342 */         }).r(), x1 + 120, cy);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tourism\Tourism.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */