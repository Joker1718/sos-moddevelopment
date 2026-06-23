/*     */ package world.region;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.misc.STRING_RECIEVER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PlacableSimpleTile;
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
/*     */ class null
/*     */   extends PlacableSimpleTile
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/* 158 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public void place(int tx, int ty) {
/* 162 */     final Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 163 */     if (reg != null && reg.faction() instanceof game.faction.npc.FactionNPC) {
/* 164 */       STRING_RECIEVER str = new STRING_RECIEVER()
/*     */         {
/*     */           public void acceptString(CharSequence string)
/*     */           {
/* 168 */             if (string != null)
/* 169 */               (reg.faction()).name.clear().add(string); 
/* 170 */             (reg.faction().capitolRegion()).info.name().clear().add((CharSequence)(reg.faction()).name);
/*     */           }
/*     */         };
/*     */       
/* 174 */       (VIEW.inters()).input.requestInput(str, "set faction name");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty) {
/* 180 */     Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 181 */     if (reg != null && reg.faction() instanceof game.faction.npc.FactionNPC) {
/* 182 */       return null;
/*     */     }
/* 184 */     return E;
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 189 */     return (SPRITE)(UI.icons()).m.menu;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\Placers$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */