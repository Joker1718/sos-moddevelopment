/*     */ package world.region.building;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.sprite.SPRITES;
/*     */ import init.value.GVALUES;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.INFO;
/*     */ import util.text.Dic;
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
/*     */ public final class RDBuildPoint
/*     */ {
/*     */   public final int index;
/*     */   public final SPRITE icon;
/*     */   public final INFO info;
/*     */   public final Boostable bo;
/* 175 */   private final double[] lastValue = new double[1023];
/* 176 */   private final int[] consumed = Alloc.ii(1023);
/* 177 */   private final double[] eff = new double[1023];
/* 178 */   private final double BI = 1.0E-6D;
/*     */   RDBuildPoint(int index, String key, Json data, Json text) throws IOException {
/* 180 */     this.index = index;
/* 181 */     this.icon = (SPRITE)SPRITES.icons().get(data);
/* 182 */     this.info = new INFO(text);
/* 183 */     this.bo = BOOSTING.push("POINT_" + key, 0.0D, this.info.name, this.info.desc, this.icon, (BoostableCat.ALL()).WORLD);
/*     */     
/* 185 */     GVALUES.REGION.push("EFFICIENCY_" + key, this.info.name, this.icon, new DOUBLE_O<Region>()
/*     */         {
/*     */           public double getD(Region t)
/*     */           {
/* 189 */             return RDBuildPoints.RDBuildPoint.this.eff(t);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 194 */     (new BoostSpecs(this.info.name, this.icon, true)).read(data, (BValue)new BValue.BValuePlayerOnly()
/*     */         {
/*     */           public double vGet(Player f)
/*     */           {
/* 198 */             int am = 0;
/* 199 */             for (int i = 0; i < f.realm().regions(); i++)
/* 200 */               am = (int)(am + RDBuildPoints.RDBuildPoint.this.lastValue[f.realm().region(i).index()]); 
/* 201 */             return am;
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(Region reg) {
/* 206 */             RDBuildPoints.RDBuildPoint.access$0(RDBuildPoints.RDBuildPoint.this).calc();
/* 207 */             return (int)RDBuildPoints.RDBuildPoint.this.lastValue[reg.index()] * 1.0E-6D;
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(FactionNPC f) {
/* 212 */             return 0.0D;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   RDBuildPoint(int index, Boostable bo) throws IOException {
/* 219 */     this.index = index;
/* 220 */     this.icon = bo.icon.medium;
/* 221 */     this.info = new INFO(bo.name, bo.desc);
/* 222 */     this.bo = bo;
/*     */     
/* 224 */     GVALUES.REGION.push("EFFICIENCY_" + bo.key, this.info.name, this.icon, new DOUBLE_O<Region>()
/*     */         {
/*     */           public double getD(Region t)
/*     */           {
/* 228 */             return RDBuildPoints.RDBuildPoint.this.eff(t);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double eff(Region reg) {
/* 237 */     if (reg.faction() != FACTIONS.player()) {
/* 238 */       return 1.0D;
/*     */     }
/* 240 */     if (RDBuildPoints.this.dirty() || this.lastValue[reg.index()] != this.bo.get((BOOSTABLE_O)reg)) {
/* 241 */       RDBuildPoints.this.calc();
/*     */     }
/* 243 */     return this.eff[reg.index()];
/*     */   }
/*     */   
/*     */   public int consumed(Region reg) {
/* 247 */     RDBuildPoints.this.calc();
/* 248 */     return this.consumed[reg.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public int consumed(Faction f) {
/* 253 */     RDBuildPoints.this.calc();
/* 254 */     int am = 0;
/* 255 */     for (int ri = 0; ri < f.realm().regions(); ri++) {
/* 256 */       Region r = f.realm().region(ri);
/* 257 */       am += this.consumed[r.index()];
/*     */     } 
/* 259 */     return -am;
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX box, Region reg) {
/* 263 */     GBox b = (GBox)box;
/* 264 */     box.title(this.bo.name);
/* 265 */     box.text(this.bo.desc);
/* 266 */     box.NL();
/*     */     
/* 268 */     this.bo.hoverDetailed(box, (BOOSTABLE_O)reg, Dic.¤¤Produced, true);
/* 269 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\building\RDBuildPoints$RDBuildPoint.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */