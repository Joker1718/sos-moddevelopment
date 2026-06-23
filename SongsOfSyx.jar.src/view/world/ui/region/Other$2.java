/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FBanner;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
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
/*     */ class null
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/*  86 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/*  90 */     (VIEW.world()).UI.factions.hover(text, ((Region)g.get()).faction());
/*  91 */     super.hoverInfoGet(text);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  97 */     Region reg = (Region)g.get();
/*  98 */     if (reg.faction() == null) {
/*  99 */       FBanner.rebel.HUGE.renderC(r, body().cX(), body().cY());
/*     */     } else {
/* 101 */       GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)body());
/* 102 */       (reg.faction().banner()).HUGE.renderC(r, body().cX(), body().cY());
/* 103 */       if (DIP.WAR().is((Faction)FACTIONS.player(), reg.faction())) {
/* 104 */         COLOR.REDISH.bind();
/* 105 */         (UI.icons()).s.sword.render(r, body().x2() - 16, body().y1());
/*     */       } 
/* 107 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)body());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 114 */     if (((Region)g.get()).faction() instanceof FactionNPC)
/* 115 */       (VIEW.world()).UI.factions.open((FactionNPC)((Region)g.get()).faction()); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\Other$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */