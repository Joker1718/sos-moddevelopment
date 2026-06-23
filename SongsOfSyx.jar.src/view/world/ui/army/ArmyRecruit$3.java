/*     */ package view.world.ui.army;
/*     */ 
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.faction.FResources;
/*     */ import init.constant.Config;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResSupply;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.gui.misc.GButt;
/*     */ import view.ui.div.UIDivCardWorld;
/*     */ import world.army.AD;
/*     */ import world.army.WDivRegional;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   private final ArrayList<DIV_SPEC> li;
/*     */   
/*     */   null(CharSequence $anonymous0) {
/*  91 */     super($anonymous0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     this.li = new ArrayList(1);
/*     */   }
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 132 */     this.li.clearSloppy();
/* 133 */     this.li.add(ArmyRecruit.this.editor.div());
/* 134 */     UIDivCardWorld.hoverSendOut((LIST)this.li, text);
/*     */   }
/*     */   
/*     */   protected void clickA() {
/*     */     if (Army.army.divs().canAdd()) {
/*     */       WDivRegional d = AD.regional().create(ArmyRecruit.this.editor.div().race(), ArmyRecruit.this.editor.div().men() / (Config.battle()).MEN_PER_DIVISION, Army.army);
/*     */       d.bannerSet(ArmyRecruit.this.editor.div().bannerI());
/*     */       for (ResSupply s : (RESOURCES.SUP()).ALL) {
/*     */         if (s.health <= 0.0D)
/*     */           continue; 
/*     */         int am = s.amount(ArmyRecruit.this.editor.div().race(), ArmyRecruit.this.editor.div().men());
/*     */         am = CLAMP.i(am, 0, ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(s.resource));
/*     */         if (am > 0) {
/*     */           s.resource.remove(am, FResources.RTYPE.ARMY_SUPPLY);
/*     */           AD.supplies().get(s).current().inc(Army.army, am);
/*     */         } 
/*     */       } 
/*     */       for (StatsBattle.StatTraining s : (STATS.BATTLE()).TRAINING_ALL)
/*     */         d.target.trainingSet(s, ArmyRecruit.this.editor.div().training(s)); 
/*     */       for (EquipBattle s : STATS.EQUIP().BATTLE_ALL())
/*     */         d.target.equipSet(s, ArmyRecruit.this.editor.div().equip(s)); 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void renAction() {
/*     */     activeSet((ArmyRecruit.this.problem() == null));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\ArmyRecruit$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */