/*     */ package game.event.engine;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.event.actions.EventAction;
/*     */ import game.faction.FACTIONS;
/*     */ import init.settings.S;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
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
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/* 107 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void clickA() {
/* 111 */     VIEW.messages().hide();
/* 112 */     for (EventAction a : c.actions) {
/* 113 */       if (a.problem(e, EventMessage.this.data) != null) {
/*     */         return;
/*     */       }
/*     */     } 
/* 117 */     if (!c.request.passes(FACTIONS.player()))
/*     */       return; 
/* 119 */     GAME.EVENT().choiceSelect(e, k);
/*     */ 
/*     */     
/* 122 */     EventMessage.this.choice = k;
/* 123 */     for (EventAction a : c.actions) {
/* 124 */       a.exe(e, EventMessage.this.data);
/*     */     }
/* 126 */     if (GAME.EVENT().current() == e) {
/* 127 */       GAME.EVENT().set(null, false, false, false, false);
/*     */     }
/* 129 */     super.clickA();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 135 */     super.render(r, ds, isActive, isSelected, isHovered);
/* 136 */     if (!c.request.passes(FACTIONS.player())) {
/* 137 */       OPACITY.O50.bind();
/* 138 */       COLOR.WHITE50.render(r, (RECTANGLE)this.body, -2);
/* 139 */       OPACITY.unbind();
/*     */       return;
/*     */     } 
/* 142 */     for (EventAction a : c.actions) {
/* 143 */       if (a.problem(e, EventMessage.this.data) != null) {
/* 144 */         OPACITY.O50.bind();
/* 145 */         COLOR.WHITE50.render(r, (RECTANGLE)this.body, -2);
/* 146 */         OPACITY.unbind();
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 155 */     selectedSet((EventMessage.this.choice == k));
/* 156 */     activeSet((EventMessage.this.iteration == GAME.EVENT().occ(e) && GAME.EVENT().current() == e));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 161 */     GBox b = (GBox)text;
/* 162 */     b.title(c.name);
/*     */     
/* 164 */     if (EventMessage.this.iteration != GAME.EVENT().occ(e) || GAME.EVENT().current() != e) {
/* 165 */       b.error(EventMessage.¤¤active);
/* 166 */       b.NL();
/* 167 */       if (!(S.get()).developer) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 173 */     for (EventAction a : c.actions) {
/* 174 */       if (!a.hideUI) {
/* 175 */         a.hover(b, e, EventMessage.this.data);
/* 176 */         b.NL(8);
/*     */       } 
/*     */     } 
/* 179 */     b.NL();
/* 180 */     for (EventAction a : c.actions) {
/* 181 */       CharSequence p = a.problem(e, EventMessage.this.data);
/* 182 */       if (p != null) {
/* 183 */         b.error(p);
/* 184 */         b.NL();
/*     */       } 
/*     */     } 
/*     */     
/* 188 */     if (c.request.all().size() > 0) {
/* 189 */       c.request.hover(text, FACTIONS.player());
/*     */     }
/*     */     
/* 192 */     if ((S.get()).developer) {
/* 193 */       for (EventAction a : c.actions) {
/* 194 */         b.text(a.key);
/*     */       }
/*     */     }
/* 197 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\EventMessage$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */