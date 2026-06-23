/*     */ package settlement.path.finders;
/*     */ 
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.FindableDataSingle;
/*     */ import settlement.path.components.SCompNLevel;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.SComponentEdge;
/*     */ import settlement.stats.STATS;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SFinderHumanoid
/*     */ {
/*     */   private Humanoid asker;
/*     */   private FindableDataSingle ti;
/*     */   private Humanoid res;
/*     */   private boolean hostile;
/*     */   
/*  22 */   private final SFINDER fin = new SFINDER()
/*     */     {
/*     */       public boolean isInComponent(SComponent c, double distance)
/*     */       {
/*  26 */         int am = SFinderHumanoid.this.ti.get(c);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  32 */         return (am > 0);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isTile(int tx, int ty, int tileNr) {
/*  37 */         for (ENTITY e : SETT.ENTITIES().getAtTile(tx, ty)) {
/*  38 */           if (e instanceof Humanoid && e != SFinderHumanoid.this.asker) {
/*  39 */             SFinderHumanoid.this.res = (Humanoid)e;
/*  40 */             if (SFinderHumanoid.this.res.indu().hType().isHostile() == SFinderHumanoid.this.hostile)
/*  41 */               return true; 
/*     */           } 
/*     */         } 
/*  44 */         return false;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean enemiesAreNear(Humanoid client) {
/*  64 */     if (SETT.INVADOR().invading() || STATS.POP().pop(HTYPES.ENEMY()) > (STATS.POP()).POP.data().get(null) * 0.1D) {
/*  65 */       SComponent ss = (SComponent)((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(client.tc());
/*  66 */       if (ss == null)
/*  67 */         return false; 
/*  68 */       if ((SETT.PATH()).comps.data.people(client.indu().hostile()).get(ss) > 0)
/*  69 */         return true; 
/*  70 */       SComponentEdge e = ss.edgefirst();
/*  71 */       while (e != null) {
/*  72 */         if ((SETT.PATH()).comps.data.people(client.indu().hostile()).get(e.to()) > 0)
/*  73 */           return true; 
/*  74 */         e = e.next();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  79 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Humanoid find(Humanoid client, int radius) {
/*  84 */     this.asker = client;
/*  85 */     this.ti = (SETT.PATH()).comps.data.people(!client.indu().hostile());
/*     */     
/*  87 */     if ((STATS.POP()).POP.data(null).get(null, 0) < 2) {
/*  88 */       return null;
/*     */     }
/*  90 */     this.ti.reportAbsence(client.ssx(), client.ssy());
/*     */     
/*  92 */     this.hostile = client.indu().hostile();
/*     */     
/*  94 */     if ((SETT.PATH()).finders.finder().find(client.tc().x(), client.tc().y(), this.fin, radius) != null) {
/*  95 */       this.ti.reportPresence(client.ssx(), client.ssy());
/*  96 */       return this.res;
/*     */     } 
/*     */     
/*  99 */     this.ti.reportPresence(client.ssx(), client.ssy());
/*     */     
/* 101 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Humanoid enemy(Humanoid client, int radius) {
/* 107 */     this.asker = client;
/* 108 */     this.ti = (SETT.PATH()).comps.data.people(client.indu().hostile());
/* 109 */     this.hostile = !client.indu().hostile();
/* 110 */     if ((SETT.PATH()).finders.finder().find(client.tc().x(), client.tc().y(), this.fin, radius) != null) {
/* 111 */       return this.res;
/*     */     }
/*     */     
/* 114 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SComponent findComp(Humanoid client, int radius) {
/* 119 */     this.asker = client;
/* 120 */     this.ti = (SETT.PATH()).comps.data.people(!client.indu().hostile());
/* 121 */     this.ti.reportAbsence(client.ssx(), client.ssy());
/* 122 */     SComponent s = (SETT.PATH()).comps.pather.get(client.ssx(), client.ssy(), this.fin, radius);
/* 123 */     this.ti.reportPresence(client.ssx(), client.ssy());
/* 124 */     return s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderHumanoid.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */