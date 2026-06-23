/*     */ package settlement.room.main;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoomExperienceBonus
/*     */ {
/*     */   public final double bonus;
/*     */   public final int maxEmployed;
/*     */   public final int minEmployed;
/*     */   private final double ie;
/*     */   public final RoomBlueprintImp blue;
/*     */   public final Boostable boostable;
/*     */   
/*     */   public RoomExperienceBonus(final RoomBlueprintImp blue, Json data, Boostable boostable) {
/* 150 */     BonusExperience.all.add(this);
/* 151 */     this.blue = blue;
/* 152 */     this.boostable = boostable;
/*     */ 
/*     */     
/* 155 */     int ma = 1000;
/* 156 */     double bo = 1.0D;
/*     */     
/* 158 */     if (data.has("EXPERIENCE_BONUS")) {
/* 159 */       data = data.json("EXPERIENCE_BONUS");
/* 160 */       ma = data.i("MAX_EMPLOYEES", 50, 2147483647);
/* 161 */       bo = data.d("BONUS");
/*     */     } 
/*     */     
/* 164 */     this.maxEmployed = ma;
/* 165 */     this.minEmployed = 50;
/* 166 */     this.bonus = bo;
/* 167 */     this.ie = 1.0D / (this.maxEmployed - this.minEmployed);
/* 168 */     BValue.BValueFaction bValueFaction = new BValue.BValueFaction(boostable)
/*     */       {
/*     */         public double vGet(Player f)
/*     */         {
/* 172 */           return CLAMP.d((blue.employment().employed() - BonusExperience.RoomExperienceBonus.this.minEmployed) * BonusExperience.RoomExperienceBonus.this.ie, 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(FactionNPC f) {
/* 177 */           return 0.0D;
/*     */         }
/*     */       };
/*     */     
/* 181 */     BoosterValue bos = new BoosterValue((BValue)bValueFaction, new BSourceInfo(BonusExperience.¤¤name, (SPRITE)(UI.icons()).s.clock), 0.0D, this.bonus, false);
/*     */     
/* 183 */     bos.add(boostable);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\BonusExperience$RoomExperienceBonus.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */