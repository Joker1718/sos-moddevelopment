/*     */ package init.race;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipCivic;
/*     */ import settlement.stats.equip.WearableResource;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ 
/*     */ public class RaceResources
/*     */ {
/*     */   public final LIST<RaceResource> ALL;
/*     */   public final RBIT BIT;
/*  25 */   private final RaceResource[] map = new RaceResource[RESOURCES.ALL().size()];
/*     */   
/*  27 */   private final ArrayList<ArrayListGrower<WearableResource>> perCl = new ArrayList(HCLASS_RACE.ALL().size());
/*     */   
/*     */   private final LIST<LIST<RES_AMOUNT>> homeres;
/*     */   
/*     */   private final LIST<RES_AMOUNT> homeresAll;
/*     */   
/*     */   RaceResources(LIST<Race> races) {
/*  34 */     ArrayList<LIST<RES_AMOUNT>> ress = new ArrayList(HCLASSES.ALL().size());
/*  35 */     RES_AMOUNT.Imp[] arrayOfImp1 = new RES_AMOUNT.Imp[RESOURCES.ALL().size()];
/*     */     
/*  37 */     for (HCLASS c : HCLASSES.ALL()) {
/*  38 */       ArrayList<RES_AMOUNT> rr = new ArrayList(RESOURCES.ALL().size());
/*  39 */       for (RESOURCE res : RESOURCES.ALL()) {
/*  40 */         int am = 0;
/*  41 */         for (Race r : RACES.all()) {
/*  42 */           am = Math.max(am, r.home().clas(c).amount(res));
/*     */         }
/*  44 */         if (am > 0) {
/*  45 */           rr.add(new RES_AMOUNT.Abs(res, am));
/*  46 */           if (arrayOfImp1[res.index()] != null) {
/*  47 */             arrayOfImp1[res.index()].set(Math.max(arrayOfImp1[res.index()].amount(), am)); continue;
/*     */           } 
/*  49 */           arrayOfImp1[res.index()] = new RES_AMOUNT.Imp(res, am);
/*     */         } 
/*     */       } 
/*     */       
/*  53 */       ress.add(new ArrayList((Iterable)rr));
/*     */     } 
/*  55 */     this.homeres = (LIST<LIST<RES_AMOUNT>>)ress;
/*     */     
/*  57 */     LinkedList<RES_AMOUNT> tm = new LinkedList(); byte b; int i; RES_AMOUNT.Imp[] arrayOfImp2;
/*  58 */     for (i = (arrayOfImp2 = arrayOfImp1).length, b = 0; b < i; ) { RES_AMOUNT.Imp imp = arrayOfImp2[b];
/*  59 */       if (imp != null)
/*  60 */         tm.add(imp); 
/*     */       b++; }
/*     */     
/*  63 */     this.homeresAll = (LIST<RES_AMOUNT>)new ArrayList((Iterable)tm);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  70 */     ArrayListGrower<RaceResource> all = new ArrayListGrower();
/*  71 */     RBIT.RBITImp bit = new RBIT.RBITImp();
/*     */     
/*  73 */     for (Race r : races) {
/*  74 */       for (HCLASS cl : HCLASSES.ALL()) {
/*  75 */         int j = 0;
/*  76 */         for (RES_AMOUNT a : r.home().clas(cl).resources()) {
/*  77 */           if (this.map[a.resource().index()] == null) {
/*  78 */             RaceResource res = new RaceResource((LISTE<RaceResource>)all, a.resource());
/*  79 */             this.map[res.res.index()] = res;
/*  80 */             bit.or(res.res);
/*     */           } 
/*  82 */           ((ArrayListGrower)(this.map[a.resource().index()]).map.get((cl.get(r)).index)).add(STATS.HOME().furniture(j));
/*  83 */           j++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  88 */     for (EquipCivic e : STATS.EQUIP().civics()) {
/*  89 */       if (this.map[e.resource.index()] == null) {
/*  90 */         RaceResource res = new RaceResource((LISTE<RaceResource>)all, e.resource);
/*  91 */         this.map[res.res.index()] = res;
/*  92 */         bit.or(res.res);
/*     */       } 
/*  94 */       for (Race r : races) {
/*  95 */         for (HCLASS cl : HCLASSES.ALL()) {
/*  96 */           ((ArrayListGrower)(this.map[e.resource().index()]).map.get((cl.get(r)).index)).add(e);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     while (this.perCl.hasRoom())
/* 105 */       this.perCl.add(new ArrayListGrower()); 
/* 106 */     for (HCLASS_RACE cl : HCLASS_RACE.ALL()) {
/* 107 */       for (RaceResource r : all) {
/* 108 */         ((ArrayListGrower)this.perCl.get(cl.index)).add((Iterable)r.map.get(cl.index));
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 113 */     this.ALL = (LIST<RaceResource>)all;
/* 114 */     this.BIT = (RBIT)bit;
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<RES_AMOUNT> homeResMax(HCLASS c) {
/* 119 */     if (c == null)
/* 120 */       return this.homeresAll; 
/* 121 */     return (LIST<RES_AMOUNT>)this.homeres.get(c.index());
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<WearableResource> get(HCLASS_RACE cl, RESOURCE res) {
/* 126 */     return (LIST<WearableResource>)(this.map[res.index()]).map.get(cl.index);
/*     */   }
/*     */   
/*     */   public RaceResource get(RESOURCE res) {
/* 130 */     return this.map[res.index()];
/*     */   }
/*     */   
/*     */   public LIST<WearableResource> all(HCLASS_RACE cl) {
/* 134 */     return (LIST<WearableResource>)this.perCl.get(cl.index);
/*     */   }
/*     */   
/*     */   public static class RaceResource
/*     */     implements INDEXED {
/*     */     public final RESOURCE res;
/*     */     private final int index;
/* 141 */     private final ArrayList<ArrayListGrower<WearableResource>> map = new ArrayList(HCLASS_RACE.ALL().size());
/*     */     
/*     */     RaceResource(LISTE<RaceResource> all, RESOURCE res) {
/* 144 */       this.res = res;
/* 145 */       this.index = all.add(this);
/* 146 */       while (this.map.hasRoom()) {
/* 147 */         this.map.add(new ArrayListGrower());
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public int index() {
/* 153 */       return this.index;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\RaceResources.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */