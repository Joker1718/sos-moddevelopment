/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.colls.StatsFood;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.Checkbox
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/*  88 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void clickA() {
/*  92 */     s.allowed(k).toggle(c, (Race)race.get());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/*  97 */     selectedSet(s.allowed(k).get(c, (Race)race.get()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 103 */     if (race.get() != null && (((Race)race.get()).pref()).foodMask.has(e)) {
/* 104 */       COLOR.WHITE100.render(r, (RECTANGLE)this.body, 1);
/* 105 */       COLOR.WHITE15.render(r, (RECTANGLE)this.body, 0);
/*     */     } 
/* 107 */     super.render(r, ds, isActive, isSelected, isHovered);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 114 */     GBox b = (GBox)text;
/* 115 */     text.title(e.name);
/* 116 */     if (selectedIs()) {
/* 117 */       b.text(CatAccess.¤¤Allowed);
/*     */     } else {
/* 119 */       b.error(CatAccess.¤¤AllowedNot);
/* 120 */     }  b.NL(4);
/* 121 */     b.textLL(CatAccess.¤¤PreferedBy);
/* 122 */     b.NL();
/* 123 */     if (RESOURCES.EDI().is(e)) {
/* 124 */       for (Race r : RACES.all()) {
/* 125 */         if ((r.pref()).food.contains(RESOURCES.EDI().get(e))) {
/* 126 */           b.add((SPRITE)(r.appearance()).iconBig);
/*     */         }
/*     */       } 
/*     */     }
/* 130 */     if (RESOURCES.DRINKS().is(e))
/* 131 */       for (Race r : RACES.all()) {
/* 132 */         if ((r.pref()).drink.contains(RESOURCES.DRINKS().get(e)))
/* 133 */           b.add((SPRITE)(r.appearance()).iconBig); 
/*     */       }  
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatAccess$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */