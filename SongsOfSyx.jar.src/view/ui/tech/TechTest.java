/*     */ package view.ui.tech;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.player.PTech;
/*     */ import init.tech.TECH;
/*     */ import init.tech.TECHS;
/*     */ import init.tech.TechCost;
/*     */ import init.value.Lock;
/*     */ import java.util.Iterator;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.employment.RoomEquip;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ class TechTest extends HOVERABLE.HoverableAbs {
/*     */   public static GuiSection get() {
/*  37 */     GuiSection s = new GuiSection();
/*  38 */     TechTest t = new TechTest();
/*  39 */     int i = 0;
/*  40 */     int y1 = 0;
/*  41 */     int x1 = 0;
/*  42 */     for (Plot p : t.plots) {
/*  43 */       GButt.Checkbox c = new GButt.Checkbox(p.blue.icon.small)
/*     */         {
/*     */           protected void clickA() {
/*  46 */             p.show = !p.show;
/*     */           }
/*     */           
/*     */           protected void renAction() {
/*  50 */             selectedSet(p.show);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  55 */             GBox b = (GBox)text;
/*  56 */             double bo = 0.0D;
/*  57 */             double cost = 0.0D;
/*  58 */             for (TechTest.Line l : p.lines) {
/*  59 */               b.text(l.name);
/*  60 */               b.add((SPRITE)GFORMAT.f0(b.text(), l.bo));
/*  61 */               b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)l.cost));
/*  62 */               bo += l.bo;
/*  63 */               cost += l.cost;
/*  64 */               text.NL();
/*     */             } 
/*     */             
/*  67 */             b.add((SPRITE)GFORMAT.f0(b.text(), bo));
/*  68 */             b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)cost));
/*     */           }
/*     */         };
/*     */       
/*  72 */       s.add((RENDEROBJ)c, x1, y1);
/*  73 */       if (i++ > 10) {
/*  74 */         y1 = s.body().y2();
/*  75 */         i = 0;
/*  76 */         x1 = 0; continue;
/*     */       } 
/*  78 */       x1 += c.body().width();
/*     */     } 
/*     */     
/*  81 */     GuiSection ff = new GuiSection();
/*  82 */     ff.add((RENDEROBJ)t);
/*  83 */     ff.addRelBody(80, DIR.E, (SPRITE)new GText((UI.FONT()).S, "y = boost, x = cost"));
/*  84 */     s.addRelBody(16, DIR.S, (RENDEROBJ)ff);
/*     */     
/*  86 */     return s;
/*     */   }
/*     */ 
/*     */   
/*  90 */   static int width = 600;
/*  91 */   static int height = 600;
/*     */   
/*     */   private static final double COSTI = 0.001D;
/*     */   private static final double BI = 0.16666666666666666D;
/*  95 */   private final ArrayListGrower<Plot> plots = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */   
/*     */   private TechTest() {
/* 100 */     for (RoomBlueprint b : SETT.ROOMS().all()) {
/* 101 */       if (b instanceof INDUSTRY_HASER) {
/* 102 */         INDUSTRY_HASER i = (INDUSTRY_HASER)b;
/* 103 */         if (((Industry)i.industries().get(0)).outs().size() > 0) {
/* 104 */           Plot p = new Plot(((Industry)i.industries().get(0)).blue);
/* 105 */           if (p.prevCost > 0.0D) {
/* 106 */             this.plots.add(p);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 112 */     body().setDim(width, height);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 117 */     for (Plot p : this.plots)
/* 118 */       p.render(r); 
/* 119 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 124 */     int dx = VIEW.mouse().x() - this.body.x1();
/* 125 */     int dy = height - VIEW.mouse().y() - this.body.y1();
/* 126 */     GBox b = (GBox)text;
/* 127 */     b.add((SPRITE)b.text().add('x').add(dx / 0.001D / width));
/* 128 */     b.add((SPRITE)b.text().add('y').add(dy / 0.16666666666666666D / height));
/*     */   }
/*     */   
/*     */   private class Plot
/*     */   {
/*     */     private final RoomBlueprintImp blue;
/* 134 */     private double prevBo = 0.0D;
/* 135 */     private double prevCost = 0.0D;
/* 136 */     private double bo = 0.0D;
/* 137 */     private double cost = 0.0D;
/*     */     private final COLOR col;
/* 139 */     String tt = "";
/* 140 */     private final ArrayListGrower<TechTest.Line> lines = new ArrayListGrower();
/*     */     
/*     */     private boolean show = false;
/*     */     
/*     */     Plot(RoomBlueprintImp blue) {
/* 145 */       this.blue = blue;
/* 146 */       this.col = (COLOR)COLOR.UNIQUE.getC(blue.index());
/* 147 */       Boostable bo = blue.bonus();
/* 148 */       if (bo == null) {
/*     */         return;
/*     */       }
/* 151 */       Bitmap1D map = new Bitmap1D(TECHS.ALL().size(), false);
/* 152 */       Bitmap1D mapN = new Bitmap1D(TECHS.ALL().size(), false);
/* 153 */       boolean has = true;
/* 154 */       int ii = 0;
/* 155 */       while (has) {
/* 156 */         mapN.clear();
/* 157 */         flush();
/* 158 */         has = false;
/*     */         
/* 160 */         for (TECH t : TECHS.ALL()) {
/* 161 */           TECH.TechRequirement re; if (map.get(t.index()))
/*     */             continue; 
/* 163 */           Iterator<TECH.TechRequirement> iterator = t.requires().iterator(); do { if (!iterator.hasNext())
/*     */             
/*     */             { 
/*     */               
/* 167 */               has = true;
/* 168 */               mapN.set(t.index(), true);
/* 169 */               add(t, ii); break; }  re = iterator.next(); }
/*     */           while (map.get(re.tech.index()));
/* 171 */         }  for (TECH t : TECHS.ALL()) {
/* 172 */           if (mapN.get(t.index()))
/* 173 */             map.set(t.index(), true); 
/*     */         } 
/* 175 */         ii++;
/*     */       } 
/*     */     }
/*     */     
/*     */     private void add(TECH t, int ii) {
/* 180 */       if (t.AIAmount == 0.0D) {
/*     */         return;
/*     */       }
/* 183 */       double b = boost(t) + tool(t) + upgrade(t);
/*     */       
/* 185 */       boolean ll = false;
/* 186 */       for (Lock<?> l : (Iterable<Lock<?>>)t.lockers.all()) {
/* 187 */         if (l.lockable.key.equals("ROOM_" + this.blue.key)) {
/* 188 */           ll = true;
/*     */         }
/*     */       } 
/*     */       
/* 192 */       if (b > 0.0D || ll) {
/* 193 */         if (this.tt.length() > 0) {
/* 194 */           this.tt = String.valueOf(this.tt) + " + ";
/*     */         } else {
/* 196 */           this.tt = String.valueOf(this.tt) + " ";
/*     */         } 
/* 198 */         this.tt = String.valueOf(this.tt) + " " + String.valueOf(this.tt) + "(" + String.valueOf(t.name()) + "," + cost(t) + ")";
/* 199 */         this.bo += b;
/* 200 */         this.cost += cost(t);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private double cost(TECH t) {
/* 206 */       double c = 0.0D;
/* 207 */       for (TechCost tc : t.costs) {
/* 208 */         c += PTech.costTotal(tc, t, t.levelMax);
/*     */       }
/* 210 */       return c;
/*     */     }
/*     */     
/*     */     private double boost(TECH t) {
/* 214 */       for (BoostSpec s : t.boosters.all()) {
/* 215 */         if ((SETT.ROOMS()).bonus.get(s.boostable) == this.blue) {
/* 216 */           return s.booster.to() * t.levelMax;
/*     */         }
/*     */       } 
/*     */       
/* 220 */       return 0.0D;
/*     */     }
/*     */     
/*     */     private double tool(TECH t) {
/* 224 */       for (BoostSpec s : t.boosters.all()) {
/* 225 */         if ((SETT.ROOMS()).employment.equip.boostToTarget(s.boostable) != null) {
/* 226 */           RoomEquip.Target ta = (SETT.ROOMS()).employment.equip.boostToTarget(s.boostable);
/* 227 */           if (ta.blue == this.blue) {
/* 228 */             return 0.1875D * t.levelMax * s.booster.to();
/*     */           }
/*     */         } 
/*     */       } 
/* 232 */       return 0.0D;
/*     */     }
/*     */     
/*     */     private double upgrade(TECH t) {
/* 236 */       for (Lock<?> l : (Iterable<Lock<?>>)t.lockers.all()) {
/* 237 */         String n = l.lockable.key;
/*     */         
/* 239 */         if (n.contains(this.blue.key + "_UPGRADE_")) {
/*     */           
/* 241 */           String[] nn = n.split("_UPGRADE_");
/* 242 */           if (nn.length == 2) {
/* 243 */             RoomBlueprintImp b = (RoomBlueprintImp)(SETT.ROOMS()).collection.tryGet(nn[0].replace("ROOM_", ""));
/* 244 */             if (b == this.blue) {
/* 245 */               int lev = Integer.parseInt(nn[1]);
/*     */               
/* 247 */               if (lev == 1)
/* 248 */                 return 0.8D; 
/* 249 */               if (lev == 2)
/* 250 */                 return 0.5D; 
/* 251 */               return 0.3D;
/*     */             } 
/* 253 */             return 0.0D;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 258 */       return 0.0D;
/*     */     }
/*     */     
/*     */     private void flush() {
/* 262 */       if ((this.bo == 0.0D && this.cost == 0.0D) || this.bo == this.prevBo || this.cost == this.prevCost) {
/*     */         return;
/*     */       }
/* 265 */       double startX = this.prevCost * 0.001D * TechTest.width;
/* 266 */       double startY = this.prevBo * 0.16666666666666666D * TechTest.height;
/*     */       
/* 268 */       TechTest.Line l = new TechTest.Line(this.tt, startX, startY, this.bo, this.cost);
/* 269 */       this.tt = "";
/* 270 */       this.lines.add(l);
/*     */       
/* 272 */       this.prevBo += this.bo;
/* 273 */       this.prevCost += this.cost;
/* 274 */       this.bo = 0.0D;
/* 275 */       this.cost = 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     private void render(SPRITE_RENDERER r) {
/* 280 */       if (!this.show)
/*     */         return; 
/* 282 */       for (TechTest.Line l : this.lines)
/* 283 */         l.render(r, TechTest.this.body.x1(), TechTest.this.body.y2(), this.col); 
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Line {
/* 288 */     private final VectorImp vec = new VectorImp();
/*     */     private final int mag;
/*     */     private final double startX;
/*     */     private final double startY;
/*     */     private final CharSequence name;
/*     */     public final double bo;
/*     */     public final double cost;
/*     */     
/*     */     Line(CharSequence name, double startX, double startY, double bo, double cost) {
/* 297 */       this.name = String.valueOf(name);
/* 298 */       this.startX = startX;
/* 299 */       this.startY = startY;
/* 300 */       this.mag = (int)Math.ceil(this.vec.set(cost * 0.001D * TechTest.width, bo * 0.16666666666666666D * TechTest.height));
/* 301 */       this.bo = bo;
/* 302 */       this.cost = cost;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void render(SPRITE_RENDERER r, int x1, int y1, COLOR col) {
/* 308 */       for (int i = 0; i < this.mag; i++) {
/* 309 */         int x = (int)(x1 + this.startX + this.vec.nX() * i);
/* 310 */         int y = (int)(y1 - this.startY + this.vec.nY() * i);
/* 311 */         if (i == 0) {
/* 312 */           col.render(r, x, x + 3, y, y + 3);
/*     */         } else {
/* 314 */           col.render(r, x, x + 1, y, y + 1);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\TechTest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */