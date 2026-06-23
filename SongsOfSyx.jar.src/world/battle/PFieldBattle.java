/*     */ package world.battle;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayListInt;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class PFieldBattle
/*     */   implements SAVABLE
/*     */ {
/*     */   private final Util util;
/*     */   private final Side.Conflict con;
/*     */   private final Resolver init;
/*  24 */   private final Bitmap1D map = new Bitmap1D(1024, false);
/*  25 */   private final ArrayListInt current = new ArrayListInt(1024);
/*     */   
/*     */   public PFieldBattle(Side.Conflict con, Resolver init, Util util) {
/*  28 */     this.con = con;
/*  29 */     this.init = init;
/*  30 */     this.util = util;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  35 */     this.map.save(file);
/*  36 */     this.current.save(file);
/*     */   }
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  40 */     this.map.load(file);
/*  41 */     this.current.load(file);
/*     */   }
/*     */   
/*     */   public void clear() {
/*  45 */     this.map.clear();
/*  46 */     this.current.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(WArmy a) {
/*  51 */     if (this.map.get(a.armyIndex())) {
/*     */       return;
/*     */     }
/*  54 */     this.map.set(a.armyIndex(), true);
/*  55 */     this.current.add(a.armyIndex());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean poll() {
/*  62 */     int death = 1000;
/*     */     
/*  64 */     while (!this.current.isEmpty()) {
/*  65 */       int ai = this.current.get(this.current.size() - 1);
/*  66 */       WArmy a = (WORLD.ENTITIES()).armies.get(ai);
/*  67 */       if (create(a)) {
/*  68 */         return true;
/*     */       }
/*  70 */       this.map.set(this.current.get(this.current.size() - 1), false);
/*  71 */       this.current.remove(this.current.size() - 1);
/*     */       
/*  73 */       if (death-- < 0) {
/*  74 */         LOG.err("NOHA!");
/*     */         break;
/*     */       } 
/*     */     } 
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   private boolean create(WArmy a) {
/*  82 */     if (!valid(a)) {
/*  83 */       return false;
/*     */     }
/*  85 */     WArmy e = enemy(a);
/*  86 */     if (e == null)
/*  87 */       return false; 
/*  88 */     Util.Pair allies = this.util.fill(a.faction(), e.faction(), a.ctx(), a.cty());
/*  89 */     this.con.clear();
/*     */     
/*  91 */     this.con.clear();
/*  92 */     this.con.A.add(a);
/*  93 */     for (WArmy a2 : allies.a) {
/*  94 */       if (a != a2)
/*  95 */         this.con.A.add(a2); 
/*     */     } 
/*  97 */     this.con.B.add(e);
/*  98 */     for (WArmy a2 : allies.b) {
/*  99 */       if (a != a2)
/* 100 */         this.con.B.add(a2); 
/*     */     } 
/* 102 */     this.init.init(this.con.A, this.con.B);
/* 103 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean valid(WArmy a) {
/* 109 */     return (a != null && AD.men(null).get(a) > 0);
/*     */   }
/*     */   
/*     */   private WArmy enemy(WArmy a) {
/* 113 */     if ((WORLD.PATH()).map.is.is(a.ctx(), a.cty()))
/*     */     {
/* 115 */       for (int di = 0; di < DIR.ALLC.size(); di++) {
/* 116 */         DIR d = (DIR)DIR.ALLC.get(di);
/* 117 */         if (d == DIR.C || (WORLD.PATH()).map.can(a.ctx(), a.cty(), d)) {
/*     */           
/* 119 */           int dx = a.ctx() + d.x();
/* 120 */           int dy = a.cty() + d.y();
/*     */           
/* 122 */           for (WArmy a2 : (WORLD.ENTITIES()).armies.fillTile(dx, dy)) {
/* 123 */             if (a2.ctx() == dx && a2.cty() == dy && 
/* 124 */               valid(a2) && Util.enemies(a.faction(), a2.faction())) {
/* 125 */               return a2;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 132 */     return null;
/*     */   }
/*     */   
/*     */   public void register(WArmy a) {
/* 136 */     if (this.map.get(a.armyIndex())) {
/*     */       return;
/*     */     }
/* 139 */     this.map.set(a.armyIndex(), true);
/* 140 */     this.current.add(a.armyIndex());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\PFieldBattle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */