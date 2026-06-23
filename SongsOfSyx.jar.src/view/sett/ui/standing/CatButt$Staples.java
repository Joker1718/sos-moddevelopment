/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
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
/*     */ class Staples
/*     */   extends GStaples
/*     */ {
/*     */   private final HCLASS cl;
/*     */   private final INT.INTE hov;
/*     */   private final StatCollection[] cs;
/*     */   private static final double div = 100.0D;
/*     */   private Race old;
/*     */   private final GETTER<Race> race;
/*     */   private double vmin;
/*     */   private double vmax;
/*     */   private double max;
/* 149 */   private int vI = -1;
/*     */   
/*     */   Staples(HCLASS cl, GETTER<Race> race, INT.INTE hov, StatCollection[] cs) {
/* 152 */     super(32);
/* 153 */     this.cl = cl;
/* 154 */     this.hov = hov;
/* 155 */     this.cs = cs;
/* 156 */     border(false);
/* 157 */     background(true);
/* 158 */     body().setWidth(224.0D);
/* 159 */     body().setHeight(70.0D);
/* 160 */     normalize(false);
/* 161 */     this.race = race;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, int stapleI) {
/* 166 */     box.title((this.cs[0]).info.name);
/*     */     
/* 168 */     int fromZero = 32 - stapleI - 1;
/* 169 */     box.add((SPRITE)box.text().add(-fromZero).s().add(TIME.days().cycleName()));
/* 170 */     box.NL();
/* 171 */     double p = 0.0D;
/* 172 */     double max = 0.0D;
/* 173 */     double pprev = 0.0D; byte b; int i; StatCollection[] arrayOfStatCollection;
/* 174 */     for (i = (arrayOfStatCollection = this.cs).length, b = 0; b < i; ) { StatCollection c = arrayOfStatCollection[b];
/* 175 */       box.textLL(c.info.name);
/* 176 */       box.NL();
/* 177 */       for (STAT s : c.all()) {
/* 178 */         double m = s.standing().max(this.cl, (Race)this.race.get(), fromZero);
/* 179 */         if (m == 0.0D) {
/*     */           continue;
/*     */         }
/* 182 */         double curr = s.standing().getHistoric(this.cl, (Race)this.race.get(), fromZero);
/* 183 */         box.textL((s.info()).name);
/* 184 */         box.tab(6);
/* 185 */         box.add((SPRITE)GFORMAT.fofkInv(box.text(), curr, m));
/*     */         
/* 187 */         if (fromZero < 31) {
/* 188 */           box.tab(9);
/* 189 */           int j = (int)(curr * 100.0D);
/* 190 */           double ppprev = s.standing().getHistoric(this.cl, (Race)this.race.get(), fromZero + 1);
/* 191 */           pprev += ppprev;
/* 192 */           int k = (int)(ppprev * 100.0D);
/* 193 */           double d1 = (j - k) / 100.0D;
/* 194 */           box.add((SPRITE)GFORMAT.f0(box.text(), d1));
/*     */         } 
/* 196 */         p += s.standing().getHistoric(this.cl, (Race)this.race.get(), fromZero);
/* 197 */         max += m;
/* 198 */         box.NL();
/*     */       } 
/*     */       b++; }
/*     */     
/* 202 */     box.NL(8);
/* 203 */     box.textLL(Dic.¤¤Total);
/* 204 */     box.tab(6);
/* 205 */     box.add((SPRITE)GFORMAT.fofkInv(box.text(), p, max));
/* 206 */     box.tab(9);
/* 207 */     int n = (int)(p * 100.0D);
/* 208 */     int prev = (int)(pprev * 100.0D);
/* 209 */     double inc = (n - prev) / 100.0D;
/* 210 */     box.add((SPRITE)GFORMAT.f0(box.text(), inc));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double getValue(int stapleI) {
/* 219 */     if (this.old != this.race.get() || Math.abs(this.vI - GAME.updateI()) > 60) {
/* 220 */       this.vI = GAME.updateI();
/* 221 */       this.vmin = Double.MAX_VALUE;
/* 222 */       this.vmax = Double.MIN_VALUE;
/* 223 */       this.old = (Race)this.race.get();
/* 224 */       this.max = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 229 */       for (int k = 0; k < 32; k++) {
/* 230 */         double d1 = 0.0D;
/* 231 */         double m = 0.0D; byte b1; int n; StatCollection[] arrayOfStatCollection1;
/* 232 */         for (n = (arrayOfStatCollection1 = this.cs).length, b1 = 0; b1 < n; ) { StatCollection c = arrayOfStatCollection1[b1];
/* 233 */           for (STAT s : c.all()) {
/* 234 */             d1 += s.standing().getHistoric(this.cl, (Race)this.race.get(), k);
/* 235 */             m += s.standing().max(this.cl, (Race)this.race.get(), k) - s.standing().getDismiss(this.cl, (Race)this.race.get(), k);
/*     */           }  b1++; }
/*     */         
/* 238 */         this.vmin = Math.min(this.vmin, d1);
/* 239 */         this.vmax = Math.max(this.vmax, d1);
/* 240 */         this.max = Math.max(this.max, m);
/*     */       } 
/*     */       
/* 243 */       if (this.max == 0.0D || this.vmax == 0.0D) {
/* 244 */         return 0.0D;
/*     */       }
/* 246 */       double dd = this.max * 0.05D;
/* 247 */       this.vmax = CLAMP.d(this.vmax + dd, 0.0D, this.max);
/* 248 */       this.vmin = CLAMP.d(this.vmin - dd, 0.0D, this.vmin);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 254 */     double max = 0.0D;
/* 255 */     int i = 32 - stapleI - 1;
/* 256 */     double p = 0.0D; byte b; int j; StatCollection[] arrayOfStatCollection;
/* 257 */     for (j = (arrayOfStatCollection = this.cs).length, b = 0; b < j; ) { StatCollection c = arrayOfStatCollection[b];
/* 258 */       for (STAT s : c.all()) {
/* 259 */         p += s.standing().getHistoric(this.cl, (Race)this.race.get(), i);
/* 260 */         max += s.standing().max(this.cl, (Race)this.race.get(), i) - s.standing().getDismiss(this.cl, (Race)this.race.get(), i);
/*     */       }  b++; }
/* 262 */      if (max == 0.0D) {
/* 263 */       return 0.0D;
/*     */     }
/* 265 */     p -= this.vmin;
/* 266 */     p /= this.vmax - this.vmin;
/*     */     
/* 268 */     return p;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static double value(int stapleI, StatCollection[] cs, HCLASS cl, GETTER<Race> race) {
/* 277 */     double p = 0.0D;
/* 278 */     int i = 32 - stapleI - 1; byte b; int j; StatCollection[] arrayOfStatCollection;
/* 279 */     for (j = (arrayOfStatCollection = cs).length, b = 0; b < j; ) { StatCollection c = arrayOfStatCollection[b];
/* 280 */       for (STAT s : c.all())
/* 281 */         p += s.standing().getHistoric(cl, (Race)race.get(), i);  b++; }
/*     */     
/* 283 */     return p;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 289 */     if (this.hov != null) {
/* 290 */       isHovered = true;
/* 291 */       setHovered(this.hov.get());
/*     */     } 
/*     */     
/* 294 */     super.render(r, ds, isHovered);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 299 */     if (super.hover(mCoo)) {
/* 300 */       if (this.hov != null) {
/* 301 */         this.hov.set(hoverI());
/*     */       }
/* 303 */       return true;
/*     */     } 
/* 305 */     return false;
/*     */   }
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
/*     */   protected void renderExtra(SPRITE_RENDERER r, COLOR color, int stapleI, boolean hovered, double value, int x1, int x2, int y1, int y2) {}
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
/*     */   protected void setColor(ColorImp c, int stapleI, double value) {
/* 332 */     if (this.max == 0.0D)
/*     */       return; 
/* 334 */     c.interpolate((GCOLOR.UI()).BAD.hovered, (GCOLOR.UI()).GOOD.hovered, value);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void setColorBg(ColorImp c, int stapleI, double value) {
/* 339 */     c.set(((stapleI & 0x1) == 1) ? COLOR.WHITE20 : COLOR.WHITE15);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatButt$Staples.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */