/*     */ package world.region;
/*     */ 
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends PlacableSimpleTile
/*     */ {
/*     */   private RDRace race;
/*     */   LinkedList<CLICKABLE> butts;
/*     */   
/*     */   null(CharSequence $anonymous0) {
/* 107 */     super($anonymous0);
/*     */     
/* 109 */     this.race = (RDRace)(RD.RACES()).all.get(0);
/* 110 */     this.butts = new LinkedList();
/*     */     
/* 112 */     for (RDRace r : (RD.RACES()).all) {
/* 113 */       this.butts.add((new GButt.ButtPanel((SPRITE)(r.race.appearance()).icon)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 117 */               Placers.null.this.race = r;
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 122 */               selectedSet((Placers.null.this.race == r));
/*     */             }
/* 125 */           }).hoverInfoSet(r.race.info.name));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty) {
/* 132 */     Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 133 */     if (reg != null && reg.faction() instanceof FactionNPC) {
/* 134 */       ((FactionNPC)reg.faction()).generate(this.race, false);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty) {
/* 140 */     Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 141 */     if (reg != null && reg.faction() instanceof FactionNPC) {
/* 142 */       return null;
/*     */     }
/* 144 */     return E;
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 149 */     return (SPRITE)(UI.icons()).m.citizen;
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/* 154 */     return (LIST<CLICKABLE>)this.butts;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\Placers$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */