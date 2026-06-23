/*     */ package world.map.regions;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.STRING_RECIEVER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   null(CharSequence $anonymous0) {
/* 182 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty) {
/* 187 */     final Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 188 */     (VIEW.inters()).input.requestInput(new STRING_RECIEVER()
/*     */         {
/*     */           public void acceptString(CharSequence string)
/*     */           {
/* 192 */             if (string != null)
/* 193 */               reg.info.name().clear().add(string); 
/*     */           }
/* 195 */         },  Dic.¤¤name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty) {
/* 201 */     return ((WORLD.REGIONS()).map.get(tx, ty) != null) ? null : E;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfo(int tx, int ty, GBox hoverBox) {
/* 206 */     Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 207 */     if (reg != null) {
/* 208 */       hoverBox.add((SPRITE)hoverBox.text().add(reg.index()));
/* 209 */       hoverBox.NL();
/* 210 */       hoverBox.text((CharSequence)reg.info.name());
/*     */     } 
/* 212 */     super.hoverInfo(tx, ty, hoverBox);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderOverlay(GameWindow window) {
/* 219 */     hov.hovered = (Region)(WORLD.REGIONS()).map.get((COORDINATE)window.tile());
/* 220 */     hov.add();
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 225 */     return (SPRITE)(UI.icons()).m.menu;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\Placer$7.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */