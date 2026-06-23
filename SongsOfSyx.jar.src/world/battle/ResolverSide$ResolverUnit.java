/*     */ package world.battle;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import view.main.VIEW;
/*     */ import world.army.AD;
/*     */ import world.army.ADDiv;
/*     */ import world.army.ADSupply;
/*     */ import world.army.WDIV;
/*     */ import world.battle.spec.WBattleUnit;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ResolverUnit
/*     */   implements WBattleUnit
/*     */ {
/*     */   public Side.SideUnit unit;
/*     */   int losses;
/*     */   int lossesRetreat;
/*     */   double defences;
/*     */   
/*     */   private void init(Side.SideUnit u) {
/* 154 */     this.unit = u;
/* 155 */     this.defences = 0.0D;
/* 156 */     this.losses = 0;
/* 157 */     this.lossesRetreat = 0;
/*     */   }
/*     */   
/*     */   public void count(ResolverSide.RCount c, double looseAmount, boolean ret) {
/* 161 */     int losses = (int)Math.ceil(looseAmount * this.unit.men());
/* 162 */     count(c, losses, ret);
/*     */   }
/*     */   
/*     */   public void count(ResolverSide.RCount c, int loss, boolean ret) {
/* 166 */     double looseAm = loss / this.unit.men();
/* 167 */     int dead = 0;
/* 168 */     if (this.unit.a() != null) {
/* 169 */       WArmy a = this.unit.a();
/* 170 */       double d = 1.1D * looseAm;
/* 171 */       d = CLAMP.d(d, 0.0D, 1.0D);
/* 172 */       for (ADSupply s : (AD.supplies()).all) {
/* 173 */         int am = (int)(s.current().get(a) * d);
/* 174 */         c.res[s.res.index()] = c.res[s.res.index()] + am;
/*     */       } 
/*     */       
/* 177 */       for (int di = 0; di < a.divs().size(); di++) {
/* 178 */         ADDiv aDDiv = a.divs().get(di);
/* 179 */         int dd = (int)Math.ceil(d * aDDiv.men());
/* 180 */         c.dead[(aDDiv.race()).index] = c.dead[(aDDiv.race()).index] + dd;
/* 181 */         dead += dd;
/*     */       } 
/*     */     } else {
/* 184 */       Region reg = this.unit.r();
/* 185 */       double d = 1.1D * looseAm;
/* 186 */       for (int di = 0; di < RD.MILITARY().divisions(reg).size(); di++) {
/* 187 */         WDIV div = (WDIV)RD.MILITARY().divisions(reg).get(di);
/* 188 */         int dd = (int)Math.ceil(d * div.men());
/* 189 */         dead += dd;
/* 190 */         c.dead[div.race().index()] = c.dead[div.race().index()] + dd;
/*     */       } 
/*     */     } 
/* 193 */     if (ret) {
/* 194 */       ResolverSide.this.lossesRetreat += dead - this.lossesRetreat;
/* 195 */       this.lossesRetreat = dead;
/*     */     } else {
/* 197 */       ResolverSide.this.losses += dead - this.losses;
/* 198 */       this.losses = dead;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void extract(double looseAmount) {
/* 203 */     if (this.unit.a() != null) {
/* 204 */       extract(this.unit.a(), looseAmount);
/*     */     } else {
/* 206 */       extract(this.unit.r(), looseAmount);
/*     */     } 
/*     */   }
/*     */   public void extract(WArmy a, double looseAmount) {
/* 210 */     double d = 1.1D * looseAmount;
/* 211 */     for (ADSupply s : (AD.supplies()).all) {
/* 212 */       int am = (int)Math.ceil(s.current().get(a) * d);
/* 213 */       s.current().inc(a, -am);
/*     */     } 
/*     */     
/* 216 */     for (int di = 0; di < a.divs().size(); di++) {
/* 217 */       ADDiv aDDiv = a.divs().get(di);
/* 218 */       kill((WDIV)aDDiv, looseAmount);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void extract(Region reg, double looseAmount) {
/* 223 */     for (int di = 0; di < RD.MILITARY().divisions(reg).size(); di++) {
/* 224 */       WDIV div = (WDIV)RD.MILITARY().divisions(reg).get(di);
/* 225 */       kill(div, looseAmount);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void kill(WDIV div, double looseAmount) {
/* 230 */     int l = (int)Math.ceil(looseAmount * div.men());
/* 231 */     this.losses += l;
/*     */     
/* 233 */     int survivors = div.men() - l;
/*     */     
/* 235 */     double xp = 0.0D;
/*     */     
/* 237 */     if (survivors > 0) {
/* 238 */       xp = 0.1D * div.men() / survivors;
/* 239 */       xp += div.experience();
/* 240 */       xp = CLAMP.d(xp, 0.0D, 1.0D);
/*     */     } 
/*     */     
/* 243 */     div.resolve(survivors, xp);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/* 248 */     return (this.unit.a() != null) ? (CharSequence)(this.unit.a()).name : (CharSequence)(this.unit.r()).info.name();
/*     */   }
/*     */ 
/*     */   
/*     */   public int men() {
/* 253 */     return ResolverSide.this.men;
/*     */   }
/*     */ 
/*     */   
/*     */   public int losses() {
/* 258 */     return this.losses;
/*     */   }
/*     */ 
/*     */   
/*     */   public int lossesRetreat() {
/* 263 */     return this.lossesRetreat;
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE icon() {
/* 268 */     return (this.unit.faction() != null) ? (this.unit.faction().banner()).MEDIUM : (SPRITE)(UI.icons()).m.rebellion;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box) {
/* 273 */     if (this.unit.a() != null) {
/* 274 */       (VIEW.world()).UI.armies.hover(box, this.unit.a());
/* 275 */     } else if (this.unit.r() != null) {
/* 276 */       (VIEW.world()).UI.regions.hoverGarrison(this.unit.r(), box);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double defences() {
/* 284 */     return this.defences;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\ResolverSide$ResolverUnit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */