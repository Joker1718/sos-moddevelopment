/*     */ package view.sett.ui.room.construction;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.environment.Foundation;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   final GStat stat;
/*     */   
/*     */   null(int $anonymous0, int $anonymous1) {
/* 106 */     super($anonymous0, $anonymous1);
/* 107 */     this.stat = new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 111 */           double am = (SETT.ROOMS()).placement.placer.resNeeded(k);
/* 112 */           GFORMAT.i(text, (int)Math.ceil(am));
/* 113 */           if ((SETT.ROOMS()).placement.placer.cost().total() > 0.0D) {
/* 114 */             text.warnify();
/* 115 */             text.add('*');
/* 116 */           } else if ((SETT.ROOMS()).placement.placer.blueprint().constructor().needsIsolation() && s.placement.placer.isolation() < 1.0D) {
/* 117 */             text.warnify();
/* 118 */           } else if ((SETT.ROOMS()).placement.placer.cost().total() < 0.0D) {
/* 119 */             text.color((GCOLOR.T()).IGREAT);
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 126 */     if ((SETT.ROOMS()).placement.placer.resNeeded(k) <= 0)
/*     */       return; 
/* 128 */     s.b.constructor().resource(k).icon().render(r, body().x1(), body().y1());
/* 129 */     this.stat.render(r, body().x1() + 24 + 2, body().y1() + (body().height() - this.stat.height()) / 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 134 */     if ((SETT.ROOMS()).placement.placer.resNeeded(k) <= 0)
/*     */       return; 
/* 136 */     GBox b = (GBox)text;
/* 137 */     RESOURCE res = s.b.constructor().resource(k);
/* 138 */     b.title(res.name);
/*     */     
/* 140 */     b.add((SPRITE)b.text().lablify().add(Dic.¤¤Cost).s().add('(').add(Dic.¤¤construction).add(')'));
/* 141 */     b.tab(7);
/*     */     
/* 143 */     GText t = b.text();
/* 144 */     t.add((SETT.ROOMS()).placement.placer.resNeededNoCost(k));
/* 145 */     b.add((SPRITE)t);
/*     */     
/* 147 */     int n = (SETT.ROOMS()).placement.placer.resNeededOnlyCost(k);
/* 148 */     if (n != 0) {
/* 149 */       t = b.text();
/* 150 */       GFORMAT.iIncr(t, n);
/* 151 */       if (n > 0)
/* 152 */         t.warnify(); 
/* 153 */       if (n < 0)
/* 154 */         t.color((GCOLOR.T()).IGREAT); 
/* 155 */       b.add((SPRITE)t);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     b.NL(8);
/* 164 */     double deg = (SETT.ROOMS()).placement.placer.blueprint().degradeRate();
/* 165 */     if (deg > 0.0D) {
/* 166 */       b.add((SPRITE)b.text().lablify().add(Dic.¤¤Maintenance).s().add('(').add(DicTime.¤¤Year).add(')'));
/* 167 */       b.tab(7);
/* 168 */       deg *= 1.0D + (SETT.ROOMS()).placement.placer.cost().total();
/* 169 */       double iso = s.placement.placer.isolation();
/* 170 */       if ((SETT.ROOMS()).placement.placer.blueprint().constructor().needsIsolation()) {
/* 171 */         deg *= 1.0D + (1.0D - s.placement.placer.isolation()) * 2.0D;
/*     */       } else {
/* 173 */         iso = 1.0D;
/*     */       } 
/* 175 */       double none = ROOM_DEGRADER.rateResource(SETT.MAINTENANCE().speed(), (SETT.ROOMS()).placement.placer.blueprint().degradeRate(), iso, (SETT.ROOMS()).placement.placer.resNeededNoCost(k));
/* 176 */       double am = ROOM_DEGRADER.rateResource(SETT.MAINTENANCE().speed(), (SETT.ROOMS()).placement.placer.blueprint().degradeRate(), iso, (SETT.ROOMS()).placement.placer.resNeeded(k)) - none;
/* 177 */       none *= TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 178 */       am *= TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */       
/* 180 */       GText gText = b.text();
/* 181 */       gText.add(none, 2);
/* 182 */       b.add((SPRITE)gText);
/*     */       
/* 184 */       if (am != 0.0D) {
/* 185 */         gText = b.text();
/* 186 */         GFORMAT.f0(gText, am);
/* 187 */         if (am > 0.0D) {
/* 188 */           gText.warnify();
/*     */         } else {
/* 190 */           gText.color((GCOLOR.T()).IGREAT);
/* 191 */         }  b.add((SPRITE)gText);
/*     */       } 
/*     */ 
/*     */       
/* 195 */       b.NL();
/*     */     } 
/*     */     
/* 198 */     b.sep();
/*     */     
/* 200 */     b.textLL(Dic.¤¤SupportRoom);
/* 201 */     b.tab(7);
/* 202 */     b.add((SPRITE)GFORMAT.perc(b.text(), 1.0D - (SETT.ROOMS()).placement.placer.cost().support()));
/* 203 */     b.NL();
/* 204 */     if ((SETT.ROOMS()).placement.placer.cost().support() > 0.0D) {
/* 205 */       b.add((SPRITE)b.text().warnify().add(SStats.¤¤expense));
/* 206 */       b.NL();
/*     */     } 
/*     */     
/* 209 */     b.NL(8);
/*     */     
/* 211 */     if ((SETT.ROOMS()).placement.placer.blueprint().constructor().isHeavy()) {
/* 212 */       b.textLL(Foundation.¤¤name);
/* 213 */       b.tab(7);
/* 214 */       double d = (SETT.ROOMS()).placement.placer.cost().foundation();
/* 215 */       b.add((SPRITE)GFORMAT.percInc(b.text(), -d, 2));
/* 216 */       b.NL();
/* 217 */       if (d >= 1.0D) {
/* 218 */         b.add((SPRITE)b.text().normalify2().add(SStats.¤¤foundation));
/* 219 */         b.NL();
/*     */       } else {
/*     */         
/* 222 */         b.add((SPRITE)b.text().warnify().add(SStats.¤¤foundation));
/* 223 */         b.NL();
/*     */       } 
/* 225 */       b.NL(8);
/*     */     } 
/*     */ 
/*     */     
/* 229 */     if ((SETT.ROOMS()).placement.placer.blueprint().constructor().needsIsolation()) {
/* 230 */       b.textLL((SETT.ROOMS()).isolation.info.name);
/* 231 */       b.tab(7);
/* 232 */       b.add((SPRITE)GFORMAT.perc(b.text(), s.placement.placer.isolation()));
/* 233 */       b.NL();
/* 234 */       if (s.placement.placer.isolation() < 1.0D) {
/* 235 */         b.add((SPRITE)b.text().warnify().add(SStats.¤¤isolation));
/* 236 */         b.NL();
/*     */       } 
/*     */     } 
/*     */     
/* 240 */     b.NL(8);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SStats$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */