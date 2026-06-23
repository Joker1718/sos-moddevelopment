/*     */ package view.world.ui.army;
/*     */ 
/*     */ import game.faction.diplomacy.DIP;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ import view.tool.ToolConfig;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.entity.WEntity;
/*     */ import world.entity.army.WArmy;
/*     */ import world.entity.army.WArmyState;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ class ToolMove
/*     */   extends PlacableSimpleTile {
/*     */   private boolean can = false;
/*  22 */   private Region bReg = null;
/*  23 */   private WArmy incept = null;
/*     */   
/*     */   public ToolMove() {
/*  26 */     super(Dic.¤¤Move, "");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 128 */     this.config = new ToolConfig()
/*     */       {
/*     */         public void deactivateAction() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void update(boolean UIHovered) {
/* 137 */           if (!(VIEW.world()).panels.added((VIEW.world()).UI.armies.army)) {
/* 138 */             (VIEW.world()).tools.place(null, null, false);
/*     */           }
/*     */         }
/*     */         
/*     */         public boolean back() {
/* 143 */           (VIEW.world()).panels.remove((VIEW.world()).UI.armies.army);
/* 144 */           return true;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   final ToolConfig config;
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty) {
/*     */     this.can = false;
/*     */     this.bReg = null;
/*     */     this.incept = null;
/*     */     if (AD.men(null).get(Army.army) == 0)
/*     */       return Dic.¤¤MoveCant; 
/*     */     if (Army.army.ctx() == tx && Army.army.cty() == ty)
/*     */       return E; 
/*     */     if (!WORLD.FOW().is(tx, ty))
/*     */       for (WEntity e : WORLD.ENTITIES().fill(tx * 64 + 32, ty * 64 + 32)) {
/*     */         if (e instanceof WArmy && e != Army.army) {
/*     */           this.incept = (WArmy)e;
/*     */           if (WORLD.PATH().path(Army.army.ctx(), Army.army.cty(), tx, ty, Army.army.path().treaty()) == null)
/*     */             return Dic.¤¤Unreachable; 
/*     */           this.can = true;
/*     */           WORLD.OVERLAY().hoverEntity(e);
/*     */           if (DIP.WAR().is(this.incept.faction(), Army.army.faction())) {
/*     */             VIEW.hoverBox().text(Dic.¤¤Attack);
/*     */             VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.sword);
/*     */           } else {
/*     */             VIEW.hoverBox().text(Dic.¤¤Intercept);
/*     */             VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.crossair);
/*     */           } 
/*     */           return null;
/*     */         } 
/*     */       }  
/*     */     Region reg = (Region)(WORLD.REGIONS()).centre.get(tx, ty);
/*     */     if (reg != null && WArmyState.canBesiege(Army.army, reg)) {
/*     */       WORLD.OVERLAY().hoverBox(reg);
/*     */       VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.sword);
/*     */       if (Army.army.besigeTile(reg) != null) {
/*     */         VIEW.hoverBox().text(Dic.¤¤Besiege);
/*     */         this.bReg = reg;
/*     */         this.can = true;
/*     */         return null;
/*     */       } 
/*     */       return Dic.¤¤Unreachable;
/*     */     } 
/*     */     if (WORLD.PATH().path(Army.army.ctx(), Army.army.cty(), tx, ty, Army.army.path().treaty()) == null)
/*     */       return Dic.¤¤Unreachable; 
/*     */     this.can = true;
/*     */     VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.crossair);
/*     */     VIEW.hoverBox().text(Dic.¤¤Move);
/*     */     return null;
/*     */   }
/*     */   
/*     */   public void renderOverlay(GameWindow window) {
/*     */     WORLD.OVERLAY().hoverArmy(Army.army);
/*     */   }
/*     */   
/*     */   public void renderPlaceHolder(SPRITE_RENDERER r, int tx, int ty, int cx, int cy, boolean isPlacable) {
/*     */     if (this.bReg != null || this.incept != null)
/*     */       return; 
/*     */     super.renderPlaceHolder(r, tx, ty, cx, cy, isPlacable);
/*     */   }
/*     */   
/*     */   public void place(int tx, int ty) {
/*     */     if (!this.can)
/*     */       return; 
/*     */     if (this.incept != null) {
/*     */       Army.army.intercept(this.incept);
/*     */       return;
/*     */     } 
/*     */     if (this.bReg != null) {
/*     */       Army.army.besiege(this.bReg);
/*     */     } else {
/*     */       Army.army.setDestination(tx, ty);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\ToolMove.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */