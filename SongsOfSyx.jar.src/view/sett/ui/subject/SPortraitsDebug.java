/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
/*     */ import view.sett.IDebugPanelSett;
/*     */ 
/*     */ final class SPortraitsDebug
/*     */   extends GuiSection
/*     */ {
/*  23 */   private int start = 0;
/*     */   private int race;
/*  25 */   private COLOR bg = COLOR.BLACK;
/*     */ 
/*     */   
/*     */   SPortraitsDebug() {
/*  29 */     body().setWidth(C.WIDTH());
/*  30 */     body().setHeight(C.HEIGHT());
/*     */ 
/*     */ 
/*     */     
/*  34 */     GButt.Glow glow = new GButt.Glow("randomize")
/*     */       {
/*     */         protected void clickA() {
/*  37 */           SPortraitsDebug.this.start += 50;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  42 */     glow.body().moveX1Y1(20.0D, 20.0D);
/*  43 */     add((RENDEROBJ)glow);
/*     */     
/*  45 */     glow = new GButt.Glow("racify")
/*     */       {
/*     */         protected void clickA() {
/*  48 */           SPortraitsDebug.this.race++;
/*     */         }
/*     */       };
/*     */     
/*  52 */     addRightC(20, (RENDEROBJ)glow);
/*     */     
/*  54 */     glow = new GButt.Glow("green")
/*     */       {
/*     */         protected void clickA() {
/*  57 */           SPortraitsDebug.this.bg = COLOR.GREEN100;
/*     */         }
/*     */       };
/*     */     
/*  61 */     addRightC(20, (RENDEROBJ)glow);
/*     */     
/*  63 */     IDebugPanelSett.add("Portraits", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  67 */             (VIEW.inters()).section.activate(SPortraitsDebug.this);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  75 */     this.bg.render(r, (RECTANGLE)body());
/*  76 */     super.render(r, ds);
/*  77 */     ENTITY[] ents = SETT.ENTITIES().getAllEnts();
/*     */     
/*  79 */     int m = 20;
/*  80 */     int y = 60;
/*  81 */     int x = m;
/*  82 */     int w = 160;
/*  83 */     int h = 256;
/*     */     
/*  85 */     Race ra = (Race)RACES.all().get(this.race % RACES.all().size());
/*     */     
/*  87 */     for (int i = 0; i < ents.length; i++) {
/*  88 */       int k = (i + this.start) % ents.length;
/*  89 */       if (ents[k] instanceof Humanoid) {
/*     */         
/*  91 */         Humanoid hu = (Humanoid)ents[k];
/*     */         
/*  93 */         if (hu.race() == ra) {
/*     */ 
/*     */           
/*  96 */           STATS.APPEARANCE().portraitRender(r, hu.indu(), x, y, 4);
/*     */           
/*  98 */           x += w + m;
/*  99 */           if (x + w > C.WIDTH()) {
/* 100 */             y += h + m;
/* 101 */             if (y + h > C.HEIGHT())
/*     */               break; 
/* 103 */             x = m;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\SPortraitsDebug.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */