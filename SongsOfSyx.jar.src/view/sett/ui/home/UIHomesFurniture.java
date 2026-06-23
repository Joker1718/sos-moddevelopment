/*     */ package view.sett.ui.home;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ final class UIHomesFurniture extends GuiSection {
/*  33 */   private static CharSequence ¤¤Yearly = "¤{0} per item per year, estimation: -{1} in total per year.";
/*     */   
/*  35 */   private static CharSequence ¤¤CurrentlyUsed = "¤Currently Used";
/*  36 */   private static CharSequence ¤¤CurrentTarget = "¤Current Target";
/*  37 */   private static CharSequence ¤¤CurrentMax = "¤Current Maximum";
/*  38 */   private static CharSequence ¤¤manage = "¤Limits regarding what resources that can be used, is set in the subject panels respectively.";
/*     */   
/*     */   static {
/*  41 */     D.ts(UIHomesFurniture.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UIHomesFurniture(int height) {
/*  49 */     LinkedList<RES_AMOUNT> all = new LinkedList((Iterable)RACES.res().homeResMax(null));
/*  50 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/*  52 */     while (!all.isEmpty()) {
/*     */       
/*  54 */       int am = 0;
/*  55 */       RES_AMOUNT rES_AMOUNT = (RES_AMOUNT)all.removeFirst();
/*  56 */       GuiSection s = new GuiSection();
/*  57 */       rows.add(s);
/*  58 */       s.add((RENDEROBJ)new REN(rES_AMOUNT.resource()));
/*     */       
/*  60 */       while (!all.isEmpty() && am++ < 4) {
/*  61 */         rES_AMOUNT = (RES_AMOUNT)all.removeFirst();
/*  62 */         s.addRightC(8, (RENDEROBJ)new REN(rES_AMOUNT.resource()));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  67 */     GScrollRows r = new GScrollRows((Iterable)rows, height);
/*     */     
/*  69 */     add((RENDEROBJ)r.view());
/*     */     
/*  71 */     addRelBody(8, DIR.N, (RENDEROBJ)new GHeader(((STATS.HOME()).materials.info()).name));
/*     */   }
/*     */ 
/*     */   
/*     */   private static class REN
/*     */     extends HOVERABLE.HoverableAbs
/*     */   {
/*     */     private final RESOURCE res;
/*     */     
/*  80 */     private final int[][] ti = Alloc.i2(HCLASSES.ALL().size(), RACES.all().size());
/*     */     private final GStat s;
/*     */     
/*     */     REN(RESOURCE res) {
/*  84 */       this.res = res;
/*  85 */       this.body.setDim(100.0D, 32.0D);
/*  86 */       for (HCLASS c : HCLASSES.ALL()) {
/*  87 */         for (Race r : RACES.all()) {
/*  88 */           this.ti[c.index()][r.index] = -1;
/*  89 */           for (int i = 0; i < r.home().clas(c).resources().size(); i++) {
/*  90 */             if (((RES_AMOUNT)r.home().clas(c).resources().get(i)).resource() == res) {
/*  91 */               this.ti[c.index()][r.index] = i;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*  99 */       this.s = new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 103 */             int i = UIHomesFurniture.REN.this.getCurrent();
/* 104 */             GFORMAT.i(text, i);
/*     */           }
/*     */ 
/*     */           
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 109 */             OPACITY.O50.bind();
/* 110 */             COLOR.BLACK.render(r, X1 - 4, X2 + 4, Y1 - 2, Y2 + 2);
/* 111 */             OPACITY.unbind();
/* 112 */             super.render(r, X1, X2, Y1, Y2);
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 121 */       double c = getCurrent();
/* 122 */       double max = max();
/*     */       
/* 124 */       if (max == 0.0D) {
/* 125 */         GMeter.render(r, GMeter.C_GRAY, 1.0D, (RECTANGLE)body());
/*     */       } else {
/* 127 */         double d = c / max();
/* 128 */         GMeter.render(r, GMeter.C_REDGREEN, d, (RECTANGLE)body());
/*     */       } 
/*     */       
/* 131 */       this.res.icon().renderCY(r, body().x1() + 8, body().cY());
/*     */       
/* 133 */       this.s.adjust();
/*     */       
/* 135 */       this.s.renderCY(r, body().x1() + 40, body().cY());
/*     */     }
/*     */ 
/*     */     
/*     */     private int getTarget() {
/* 140 */       int am = 0;
/* 141 */       for (HCLASS c : HCLASSES.ALL()) {
/* 142 */         for (Race r : RACES.all()) {
/* 143 */           if (this.ti[c.index()][r.index] == -1)
/*     */             continue; 
/* 145 */           am += STATS.HOME().target(c, r, this.res) * (STATS.HOME()).GETTER.stat().data(c).get(r);
/*     */         } 
/*     */       } 
/* 148 */       return am;
/*     */     }
/*     */     
/*     */     private int max() {
/* 152 */       int am = 0;
/* 153 */       for (HCLASS c : HCLASSES.ALL()) {
/* 154 */         for (Race r : RACES.all()) {
/* 155 */           if (this.ti[c.index()][r.index] == -1)
/*     */             continue; 
/* 157 */           am += STATS.HOME().max(c, r, this.res) * (STATS.HOME()).GETTER.stat().data(c).get(r);
/*     */         } 
/*     */       } 
/* 160 */       return am;
/*     */     }
/*     */     
/*     */     private int getCurrent() {
/* 164 */       int am = 0;
/* 165 */       for (HCLASS c : HCLASSES.ALL()) {
/*     */         
/* 167 */         for (Race r : RACES.all()) {
/* 168 */           if (this.ti[c.index()][r.index] == -1)
/*     */             continue; 
/* 170 */           am += STATS.HOME().current(c, r, this.ti[c.index()][r.index]);
/*     */         } 
/*     */       } 
/* 173 */       return am;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 178 */       GBox b = (GBox)text;
/* 179 */       b.title(this.res.name);
/* 180 */       b.text(((STATS.HOME()).materials.info()).desc);
/* 181 */       b.NL(4);
/* 182 */       b.text(UIHomesFurniture.¤¤manage);
/*     */       
/* 184 */       b.NL(8);
/*     */       
/* 186 */       int current = getCurrent();
/*     */       
/* 188 */       b.textL(UIHomesFurniture.¤¤CurrentlyUsed);
/* 189 */       b.tab(5);
/* 190 */       b.add((SPRITE)GFORMAT.i(b.text(), current));
/* 191 */       b.NL();
/*     */       
/* 193 */       b.textL(UIHomesFurniture.¤¤CurrentTarget);
/* 194 */       b.tab(5);
/* 195 */       b.add((SPRITE)GFORMAT.i(b.text(), getTarget()));
/* 196 */       b.NL();
/*     */       
/* 198 */       b.textL(UIHomesFurniture.¤¤CurrentMax);
/* 199 */       b.tab(5);
/* 200 */       b.add((SPRITE)GFORMAT.i(b.text(), max()));
/* 201 */       b.NL();
/*     */ 
/*     */       
/* 204 */       b.textL(Dic.¤¤ConsumptionRate);
/* 205 */       b.NL();
/* 206 */       GText t = b.text();
/* 207 */       t.add(UIHomesFurniture.¤¤Yearly);
/* 208 */       t.insert(0, STATS.HOME().rate(null, null), 2);
/* 209 */       t.insert(1, (int)(STATS.HOME().rate(null, null) * current));
/* 210 */       b.add((SPRITE)t);
/* 211 */       super.hoverInfoGet(text);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\home\UIHomesFurniture.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */