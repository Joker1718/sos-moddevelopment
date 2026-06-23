/*     */ package util;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.GameDisposable;
/*     */ import game.save.GameLoader;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.CORE;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.CircleCooIterator;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.TextureHolder;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.StatsDebugger;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.data.AreaTmp;
/*     */ import util.data.RANMAP;
/*     */ import view.interrupter.IDebugPanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GUTIL
/*     */ {
/*     */   public static Data data;
/*     */   
/*     */   public final class Data
/*     */   {
/*     */     private final StatsDebugger debugger;
/*     */     private final CircleCooIterator circleIterator;
/*  46 */     private final AreaTmp areaTmp = new AreaTmp();
/*  47 */     private final ArrayCooShort coos = new ArrayCooShort(2049);
/*     */     
/*     */     private final PathUtilOnline pathOnline;
/*  50 */     private final RANMAP ran1 = new RANMAP();
/*  51 */     private final RANMAP ran2 = new RANMAP();
/*  52 */     private ArrayList<Object> humans = new ArrayList(40000);
/*     */     
/*     */     TextureHolder texture;
/*     */     
/*     */     private Data() throws IOException {
/*  57 */       GUTIL.data = this;
/*     */ 
/*     */ 
/*     */       
/*  61 */       this.debugger = new StatsDebugger((UI.FONT()).M);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  67 */       this.pathOnline = new PathUtilOnline(SETT.TWIDTH);
/*  68 */       this.circleIterator = new CircleCooIterator(120, this.pathOnline.getFlooder());
/*  69 */       this.debugger.getClass(); this.debugger.add(new StatsDebugger.Value(this.debugger, "Ents", 0, StatsDebugger.Formatter.Amount)
/*     */           {
/*     */             protected double getValue()
/*     */             {
/*  73 */               if (SETT.ENTITIES() == null)
/*  74 */                 return 0.0D; 
/*  75 */               return SETT.ENTITIES().size();
/*     */             }
/*     */           });
/*  78 */       this.debugger.getClass(); this.debugger.add(new StatsDebugger.Value(this.debugger, "Speed", 0, StatsDebugger.Formatter.Amount)
/*     */           {
/*     */             double t;
/*     */             
/*     */             double am;
/*     */             
/*     */             protected double getValue() {
/*  85 */               this.t += GAME.SPEED.speed();
/*  86 */               this.am++;
/*  87 */               if (this.am > 30.0D) {
/*  88 */                 this.t /= this.am;
/*  89 */                 this.am = 1.0D;
/*     */               } 
/*  91 */               return this.t / this.am;
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 101 */       IDebugPanel.add("Reload Assets", new ACTION()
/*     */           {
/*     */             public void exe()
/*     */             {
/* 105 */               Path p = GAME.saver().save("debugReload");
/* 106 */               if (p != null) {
/* 107 */                 CORE.setCurrentState((CORE_STATE.Constructor)new GameLoader(p, new String[0]));
/*     */               }
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StatsDebugger debugger() {
/* 122 */     return data.debugger;
/*     */   }
/*     */   
/*     */   public static PathUtilOnline.Flooder flooder() {
/* 126 */     return data.pathOnline.getFlooder();
/*     */   }
/*     */   
/*     */   public static PathUtilOnline.Marker marker() {
/* 130 */     return data.pathOnline.marker;
/*     */   }
/*     */   
/*     */   public static PathUtilOnline.Filler filler() {
/* 134 */     return data.pathOnline.filler;
/*     */   }
/*     */   
/*     */   public static PathUtilOnline.AStar astar() {
/* 138 */     return data.pathOnline.astar;
/*     */   }
/*     */   
/*     */   public static PathUtilOnline pathTools() {
/* 142 */     return data.pathOnline;
/*     */   }
/*     */   
/*     */   public static CircleCooIterator circle() {
/* 146 */     return data.circleIterator;
/*     */   }
/*     */   
/*     */   public static ArrayCooShort coos() {
/* 150 */     return data.coos;
/*     */   }
/*     */   
/*     */   public static RANMAP ran1() {
/* 154 */     return data.ran1;
/*     */   }
/*     */   
/*     */   public static RANMAP ran2() {
/* 158 */     return data.ran2;
/*     */   }
/*     */   
/*     */   public static AreaTmp AREA() {
/* 162 */     return data.areaTmp;
/*     */   }
/*     */   
/*     */   public static ArrayList<Object> hList() {
/* 166 */     return data.humans;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\GUTIL.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */