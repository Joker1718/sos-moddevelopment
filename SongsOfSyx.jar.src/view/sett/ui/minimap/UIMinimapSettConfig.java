/*     */ package view.sett.ui.minimap;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ public abstract class UIMinimapSettConfig {
/*  20 */   public static final COLOR colAnimal = (COLOR)new ColorImp(60, 60, 60);
/*  21 */   public static final COLOR colHostile = (COLOR)new ColorImp(200, 10, 10);
/*  22 */   public static final COLOR colHostileRout = (COLOR)new ColorImp(150, 150, 0);
/*  23 */   public static final COLOR colNormal = (COLOR)new ColorImp(0, 50, 255);
/*  24 */   public static final COLOR colMustered = (COLOR)new ColorImp(0, 180, 255);
/*     */ 
/*     */   
/*     */   public abstract COLOR col(ENTITY paramENTITY);
/*     */ 
/*     */   
/*     */   public abstract boolean halfEnts();
/*     */ 
/*     */   
/*     */   public abstract boolean room(RoomBlueprintIns<?> paramRoomBlueprintIns);
/*     */ 
/*     */   
/*     */   public abstract boolean renderGrowable();
/*     */   
/*     */   public abstract boolean renderMinable();
/*     */   
/*     */   public abstract boolean renderPack();
/*     */   
/*     */   public abstract OPACITY shade();
/*     */   
/*     */   public abstract boolean renderDivs();
/*     */   
/*     */   public void addButtons(GuiSection sec, final GameWindow w, final UIMinimapSett s) {
/*  47 */     GButt.ButtPanel buttPanel = new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.plus)
/*     */       {
/*     */         protected void clickA() {
/*  50 */           w.zoomInc(-1);
/*  51 */           if (w.zoomout() < 3) {
/*  52 */             VIEW.s().getWindow().centerAt(w.pixels().cX(), w.pixels().cY());
/*  53 */             s.view.hide();
/*     */           } 
/*     */         }
/*     */       };
/*  57 */     sec.addRightC(0, (RENDEROBJ)buttPanel);
/*     */ 
/*     */ 
/*     */     
/*  61 */     buttPanel = new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.minus)
/*     */       {
/*     */         protected void clickA() {
/*  64 */           w.zoomInc(1);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/*  69 */           activeSet((w.zoomout() < w.zoomoutmax()));
/*     */         }
/*     */       };
/*     */     
/*  73 */     sec.addRightC(0, (RENDEROBJ)buttPanel);
/*     */   }
/*     */   
/*  76 */   public static final UIMinimapSettConfig NORMAL = new UIMinimapSettConfig()
/*     */     {
/*     */       public COLOR col(ENTITY e)
/*     */       {
/*  80 */         if (e instanceof Humanoid) {
/*  81 */           Humanoid a = (Humanoid)e;
/*  82 */           if (a.indu().hostile()) {
/*  83 */             if ((STATS.BATTLE()).ROUTING.indu().get(a.indu()) == 0)
/*  84 */               return colHostile; 
/*  85 */             return colHostileRout;
/*  86 */           }  if (a.division() != null) {
/*  87 */             if (a.division().settings().mustering())
/*  88 */               return colMustered; 
/*  89 */             return colNormal;
/*     */           } 
/*  91 */           return colAnimal;
/*     */         } 
/*  93 */         return null;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean halfEnts() {
/*  99 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean room(RoomBlueprintIns<?> b) {
/* 104 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean renderGrowable() {
/* 109 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean renderMinable() {
/* 114 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean renderPack() {
/* 119 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public OPACITY shade() {
/* 124 */         return OPACITY.O25;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean renderDivs() {
/* 129 */         return (KEYS.BATTLE()).SHOW_DIVISIONS.isPressed();
/*     */       }
/*     */     };
/*     */   
/* 133 */   public static final UIMinimapSettConfig ALL = new UIMinimapSettConfig()
/*     */     {
/*     */       public COLOR col(ENTITY e)
/*     */       {
/* 137 */         return NORMAL.col(e);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public boolean halfEnts() {
/* 143 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean room(RoomBlueprintIns<?> b) {
/* 148 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean renderGrowable() {
/* 153 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean renderMinable() {
/* 158 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean renderPack() {
/* 163 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public OPACITY shade() {
/* 168 */         return OPACITY.O25;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean renderDivs() {
/* 173 */         return (KEYS.BATTLE()).SHOW_DIVISIONS.isPressed();
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\minimap\UIMinimapSettConfig.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */