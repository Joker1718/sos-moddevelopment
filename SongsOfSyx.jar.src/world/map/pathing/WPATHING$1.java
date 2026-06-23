/*     */ package world.map.pathing;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.LOG;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.GUTIL;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolManager;
/*     */ import view.world.panel.IDebugPanelWorld;
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
/*     */ class null
/*     */   extends WORLD.WorldResourceManager
/*     */ {
/*     */   null() {
/*  66 */     IDebugPanelWorld.add("generate paths", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  70 */             ACTION load = new ACTION()
/*     */               {
/*     */                 public void exe()
/*     */                 {
/*  74 */                   LOG.ln("gen...");
/*     */                 }
/*     */               };
/*  77 */             WPATHING.null.this.generate(load);
/*  78 */             WPATHING.null.this.validateInit(null);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  87 */     WPATHING.this.map.saver.save(file);
/*  88 */     WPATHING.this.portArea.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  93 */     WPATHING.this.map.saver.load(file);
/*  94 */     WPATHING.this.portArea.load(file);
/*  95 */     WPATHING.this.comps = Comps.generate(ACTION.NOP, WPATHING.this.map);
/*  96 */     validateInit(null);
/*  97 */     (WORLD.OVERLAY()).debug = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 102 */     WPATHING.this.map.saver.clear();
/* 103 */     WPATHING.this.portArea.clear();
/* 104 */     WPATHING.this.comps = new Comps(WPATHING.this.map);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void validateInit(WORLD.WorldError error) {
/* 110 */     if (!WORLD.IN_BOUNDS((WORLD.REGIONS()).player.cx(), (WORLD.REGIONS()).player.cy())) {
/* 111 */       if (error != null) {
/* 112 */         error.problem = "The world has no player region centre";
/* 113 */         error.coo.set(WORLD.TBOUNDS().cX(), WORLD.TBOUNDS().cY());
/*     */       } else {
/* 115 */         LOG.ln("bad stuff");
/*     */       } 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 122 */     boolean[] reached = new boolean[1023];
/*     */     
/* 124 */     GUTIL.flooder().init(this);
/* 125 */     GUTIL.flooder().pushSloppy((WORLD.REGIONS()).player.cx(), (WORLD.REGIONS()).player.cy(), 0.0D);
/* 126 */     while (GUTIL.flooder().hasMore()) {
/* 127 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 128 */       Region reg = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t);
/* 129 */       if (reg != null && t.isSameAs(reg.cx(), reg.cy())) {
/* 130 */         reached[reg.index()] = true;
/*     */       }
/* 132 */       WPATHING.this.map.push(t, t.getValue());
/*     */     } 
/* 134 */     GUTIL.flooder().done();
/*     */ 
/*     */     
/* 137 */     for (int ri = 0; ri < 1023; ri++) {
/* 138 */       Region reg = WORLD.REGIONS().getByIndex(ri);
/* 139 */       if (reg.active() && 
/* 140 */         !reached[reg.index()]) {
/* 141 */         if (error != null) {
/* 142 */           error.problem = "This region is not connected to other regions through roads " + reg.index();
/* 143 */           error.coo.set(reg.cx(), reg.cy());
/*     */         } else {
/* 145 */           LOG.ln("reg " + String.valueOf(reg));
/*     */         } 
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void generate(ACTION loadPrint) {
/* 157 */     clear();
/* 158 */     (new Gen()).generateAll((WORLD.REGIONS()).player.cx(), (WORLD.REGIONS()).player.cy(), loadPrint);
/* 159 */     WPATHING.this.comps = Comps.generate(loadPrint, WPATHING.this.map);
/* 160 */     (WORLD.OVERLAY()).debug = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<PLACABLE> makePlacers(ToolManager tm) {
/* 167 */     return (LIST<PLACABLE>)new ArrayList(0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\WPATHING$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */