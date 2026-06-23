/*     */ package world.entity.army;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends WArmyState
/*     */ {
/*     */   Region aReg;
/*     */   WArmy aa;
/*     */   
/* 333 */   private ACTION besiege = new ACTION()
/*     */     {
/*     */       public void exe()
/*     */       {
/* 337 */         if (WArmyState.null.this.aReg.faction() != null && WArmyState.null.this.aReg.faction() instanceof FactionNPC) {
/* 338 */           ROPINION.STANCE().setNewStance((FactionNPC)WArmyState.null.this.aReg.faction(), (DipStance)DIP.WAR(), (WArmyState.null.this.aa.faction() == FACTIONS.player()));
/* 339 */           WArmyState.null.this.aa.besiege(WArmyState.null.this.aReg);
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   WArmyState update(WArmy a, double ds) {
/* 348 */     Region reg = WORLD.REGIONS().getByIndex(a.stateShort);
/*     */ 
/*     */     
/* 351 */     if (a.faction() == reg.faction() || !a.path().isValid()) {
/* 352 */       if (!a.besieging(reg)) {
/* 353 */         a.path().clear();
/* 354 */         a.stateFloat = 0.0F;
/* 355 */         return fortifying;
/*     */       } 
/* 357 */       return this;
/*     */     } 
/*     */     
/* 360 */     if (a.path().move(a, WArmy.speed * ds)) {
/* 361 */       return this;
/*     */     }
/* 363 */     a.path().clear();
/* 364 */     if (a.faction() == FACTIONS.player() && reg.faction() != a.faction() && !DIP.WAR().is(reg.faction(), a.faction()) && reg.faction() != null) {
/* 365 */       this.aReg = reg;
/* 366 */       this.aa = a;
/* 367 */       (VIEW.inters()).yesNo.activate((CharSequence)Str.TMP.clear().add(WArmyState.¤¤siege).insert(0, (CharSequence)reg.info.name()).insert(0, (CharSequence)(reg.faction()).name), this.besiege, ACTION.NOP, true);
/* 368 */       return this;
/*     */     } 
/* 370 */     WORLD.BATTLES().besige(a, reg);
/*     */ 
/*     */ 
/*     */     
/* 374 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GText info(WArmy a, GText box) {
/* 380 */     Region reg = WORLD.REGIONS().getByIndex(a.stateShort);
/* 381 */     if (reg == null) {
/* 382 */       box.normalify();
/* 383 */       box.add(name(a));
/*     */     } else {
/* 385 */       GText text = box;
/* 386 */       text.color(GCOLOR.MAP().get(reg.faction()));
/* 387 */       text.add(Dic.¤¤BesiegingSomething).insert(0, (CharSequence)reg.info.name());
/*     */     } 
/* 389 */     return box;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name(WArmy a) {
/* 394 */     return Dic.¤¤Besieging;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\army\WArmyState$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */