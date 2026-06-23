/*     */ package view.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.util.Copyable;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import settlement.room.military.artillery.ROOM_ARTILLERY;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.Dic;
/*     */ import view.ui.top.UIPanelTop;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends UIPanelTop.Butt
/*     */ {
/*     */   private DivFormationImp tmp;
/*     */   boolean shouldmuster;
/*     */   boolean problem;
/*     */   
/*     */   null(SPRITE $anonymous0) {
/* 135 */     super($anonymous0);
/*     */     
/* 137 */     this.tmp = new DivFormationImp();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 143 */     for (Div d : GAME.ARMIES().player().divisions())
/* 144 */       d.settings().musteringSet(this.shouldmuster); 
/* 145 */     for (ROOM_ARTILLERY c : (SETT.ROOMS()).ARTILLERY) {
/* 146 */       for (int i = 0; i < c.instancesSize(); i++) {
/* 147 */         if (((ArtilleryInstance)c.getInstance(i)).army() == GAME.ARMIES().player()) {
/* 148 */           ((ArtilleryInstance)c.getInstance(i)).muster(this.shouldmuster);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void renAction() {
/* 155 */     this.shouldmuster = false;
/* 156 */     this.problem = false;
/* 157 */     for (Div d : GAME.ARMIES().player().divisions()) {
/*     */       
/* 159 */       if (d.menNrOf() > 0) {
/* 160 */         this.shouldmuster |= (d.menNrOf() > 0 && !d.settings().mustering()) ? 1 : 0;
/* 161 */         if (!this.problem) {
/* 162 */           (d.order()).dest.get((Copyable)this.tmp);
/* 163 */           if (this.tmp.deployed() == 0) {
/* 164 */             this.problem = true;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 170 */     for (ROOM_ARTILLERY c : (SETT.ROOMS()).ARTILLERY) {
/* 171 */       for (int i = 0; i < c.instancesSize(); i++) {
/* 172 */         this.shouldmuster |= (((ArtilleryInstance)c.getInstance(i)).army() == GAME.ARMIES().player() && !((ArtilleryInstance)c.getInstance(i)).mustered()) ? 1 : 0;
/*     */       }
/*     */     } 
/* 175 */     selectedSet(!this.shouldmuster);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 182 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 183 */     if (this.problem) {
/* 184 */       (GCOLOR.UI()).BAD.hovered.bind();
/* 185 */       (UI.icons()).s.alert.render(r, this.body.x2() - 16, this.body.y1());
/* 186 */     } else if (this.shouldmuster) {
/* 187 */       (GCOLOR.UI()).SOSO.hovered.bind();
/* 188 */       (UI.icons()).s.alert.render(r, this.body.x2() - 16, this.body.y1());
/*     */     } 
/* 190 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 195 */     GBox b = (GBox)text;
/* 196 */     b.title(Dic.¤¤Muster);
/* 197 */     b.text(BattlePanel.¤¤MusterDesc);
/* 198 */     b.sep();
/* 199 */     if (this.problem) {
/* 200 */       b.error(BattlePanel.¤¤MusterOneProblem);
/*     */     }
/* 202 */     if (this.shouldmuster)
/* 203 */       b.warn(BattlePanel.¤¤notMustered); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattlePanel$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */