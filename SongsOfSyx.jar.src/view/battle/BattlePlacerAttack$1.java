/*     */ package view.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.Copyable;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import settlement.thing.projectiles.SProjectiles;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends BattlePlacerAttack.Target
/*     */ {
/*     */   private Div target;
/*     */   
/*     */   null(BattlePlacerAttack paramBattlePlacerAttack2) {}
/*     */   
/*     */   boolean set() {
/* 167 */     this.target = null;
/* 168 */     ENTITY e = SETT.ENTITIES().getArroundPoint(BattlePlacerAttack.this.w.pixel().x(), BattlePlacerAttack.this.w.pixel().y());
/* 169 */     if (e instanceof Humanoid) {
/* 170 */       Div d = ((Humanoid)e).division();
/* 171 */       if (d != null && d.army() == GAME.ARMIES().enemy()) {
/* 172 */         this.target = d;
/* 173 */         BattlePlacerAttack.this.s.hover(this.target);
/*     */       } 
/*     */     } 
/*     */     
/* 177 */     if (this.target == null)
/* 178 */       return false; 
/* 179 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   CharSequence name() {
/* 184 */     if (BattlePlacerAttack.this.melees && (BattlePlacerAttack.this.archers || BattlePlacerAttack.this.artillery))
/* 185 */       return (CharSequence)Str.TMP.clear().add(BattlePlacerAttack.¤¤AttackMix).s().add(BattlePlacerAttack.¤¤AttackRangedDesc).insert(0, (KEYS.MAIN()).MOD.repr()); 
/* 186 */     if (BattlePlacerAttack.this.melees)
/* 187 */       return BattlePlacerAttack.¤¤AttackMelee; 
/* 188 */     return (CharSequence)Str.TMP.clear().add(BattlePlacerAttack.¤¤AttackRanged).s().add(BattlePlacerAttack.¤¤AttackRangedDesc).insert(0, (KEYS.MAIN()).MOD.repr());
/*     */   }
/*     */ 
/*     */   
/*     */   void problem(GBox b) {
/* 193 */     BattlePlacerAttack.this.artilleryProb(this.target.reporter.body().cX(), this.target.reporter.body().cY(), true, b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void click() {
/* 200 */     for (Div dd : BattlePlacerAttack.this.s.selection()) {
/* 201 */       if (BattlePlacerAttack.this.archers && dd.settings().ammo() != null) {
/* 202 */         BattlePlacerAttack.this.task.attackRanged(this.target, dd);
/*     */       } else {
/* 204 */         BattlePlacerAttack.this.task.attackMelee(this.target, dd);
/*     */       } 
/* 206 */       (dd.order()).task.set((Copyable)BattlePlacerAttack.this.task);
/*     */     } 
/* 208 */     if (BattlePlacerAttack.this.artillery) {
/* 209 */       for (ArtilleryInstance ins : BattlePlacerAttack.this.s.artillery.selection()) {
/* 210 */         if (BattlePlacerAttack.this.testArtillery(ins, this.target.reporter.body().cX(), this.target.reporter.body().cY(), BattlePlacerAttack.this.traj)) {
/* 211 */           ins.targetDivSet(this.target, true);
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   void render(Renderer r, ShadowBatch shadowBatch, RenderData data) {
/* 219 */     BattlePlacerAttack.this.s.hover(this.target);
/* 220 */     BattleRenderer.colAttack.bind();
/*     */     
/* 222 */     Icon icon = (UI.icons()).l.swords;
/*     */     
/* 224 */     if (BattlePlacerAttack.this.melees && (BattlePlacerAttack.this.archers || BattlePlacerAttack.this.artillery)) {
/* 225 */       Icon icon1 = ((int)(VIEW.renderSecond() * 2.0D) % 2 == 1) ? (SPRITES.icons()).m.bow : (SPRITES.icons()).m.sword;
/* 226 */       icon = ((int)(VIEW.renderSecond() * 2.0D) % 2 == 1) ? (UI.icons()).l.crossheir : (UI.icons()).l.swords;
/* 227 */       VIEW.mouse().setReplacement((SPRITE)icon1);
/* 228 */     } else if (BattlePlacerAttack.this.melees) {
/* 229 */       VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.sword);
/*     */     } else {
/* 231 */       VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.bow);
/* 232 */       icon = (UI.icons()).l.crossheir;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 237 */     if (BattlePlacerAttack.this.archers || BattlePlacerAttack.this.artillery) {
/* 238 */       int i; boolean someInRange = false;
/* 239 */       boolean allInRange = true;
/* 240 */       for (Div dd : BattlePlacerAttack.this.s.selection()) {
/* 241 */         if (dd.menNrOf() > 0 && dd.settings().ammo() != null) {
/* 242 */           if (SProjectiles.problem(dd, this.target) == null) {
/* 243 */             i = someInRange | true; continue;
/*     */           } 
/* 245 */           allInRange = false;
/*     */         } 
/*     */       } 
/*     */       
/* 249 */       for (ArtilleryInstance ins : BattlePlacerAttack.this.s.artillery.selection()) {
/* 250 */         if (BattlePlacerAttack.this.testArtillery(ins, this.target.reporter.body().cX(), this.target.reporter.body().cY(), BattlePlacerAttack.this.traj)) {
/* 251 */           i |= 0x1; continue;
/*     */         } 
/* 253 */         allInRange = false;
/*     */       } 
/*     */       
/* 256 */       if (i == 0 && !BattlePlacerAttack.this.archers && BattlePlacerAttack.this.artillery) {
/* 257 */         VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.cancel);
/*     */         return;
/*     */       } 
/* 260 */       if (!allInRange) {
/* 261 */         COLOR.ORANGE100.bind();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 266 */     int cx = this.target.centre().cX() - data.offX1();
/* 267 */     int cy = this.target.centre().cY() - data.offY1();
/*     */     
/* 269 */     icon.renderCScaled((SPRITE_RENDERER)r, cx, cy, 8);
/*     */ 
/*     */ 
/*     */     
/* 273 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattlePlacerAttack$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */