/*     */ package init.race.home;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import init.sprite.game.SheetType;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.home.HOME;
/*     */ import settlement.tilemap.floor.Floors;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ public final class RaceHomeClass
/*     */ {
/*     */   private final LIST<RES_AMOUNT> amounts;
/*  21 */   private final int[] ramounts = Alloc.ii(RESOURCES.ALL().size());
/*     */   
/*     */   private final int amountTotal;
/*     */   
/*     */   public final RaceHomeSheet bedTop;
/*     */   
/*     */   public final RaceHomeSheet bedBottom;
/*     */   
/*     */   public final RaceHomeSheet carpet;
/*     */   public final RaceHomeSheet table;
/*     */   public final RaceHomeSheet nightStand;
/*     */   public final RaceHomeSheet storage;
/*     */   public final RaceHomeSheet chair;
/*     */   public final RaceHomeSheet nick1;
/*     */   public final RaceHomeSheet nickTop1;
/*     */   public final RaceHomeSheet nick2;
/*     */   public final RaceHomeSheet mat;
/*     */   public final RaceHomeSheet masterBed;
/*     */   public final RaceHomeSheet statue;
/*     */   private final int[][] fneeded;
/*     */   private Floors.Floor[] floors;
/*     */   
/*     */   RaceHomeClass() throws IOException {
/*  44 */     this.amounts = (LIST<RES_AMOUNT>)new ArrayList(0);
/*  45 */     this.amountTotal = 0;
/*     */     
/*  47 */     this.bedTop = new RaceHomeSheet();
/*  48 */     this.bedBottom = new RaceHomeSheet();
/*  49 */     this.carpet = new RaceHomeSheet();
/*  50 */     this.table = new RaceHomeSheet();
/*  51 */     this.nightStand = new RaceHomeSheet();
/*  52 */     this.storage = new RaceHomeSheet();
/*  53 */     this.chair = new RaceHomeSheet();
/*  54 */     this.nick1 = new RaceHomeSheet();
/*  55 */     this.nickTop1 = new RaceHomeSheet();
/*  56 */     this.nick2 = new RaceHomeSheet();
/*  57 */     this.mat = new RaceHomeSheet();
/*  58 */     this.masterBed = new RaceHomeSheet();
/*  59 */     this.statue = new RaceHomeSheet();
/*  60 */     this.floors = new Floors.Floor[0];
/*  61 */     this.fneeded = Alloc.i2(0, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   RaceHomeClass(Json json) throws IOException {
/*  67 */     ArrayList<RESOURCE> resses = new ArrayList(RESOURCES.ALL().size());
/*  68 */     for (String key : json.keys()) {
/*  69 */       Json[] js = json.jsons(key); byte b; int i; Json[] arrayOfJson1;
/*  70 */       for (i = (arrayOfJson1 = js).length, b = 0; b < i; ) { Json jj = arrayOfJson1[b];
/*  71 */         Json j = jj.json("RESOURCES");
/*  72 */         for (String k : j.keys()) {
/*  73 */           RESOURCE res = (RESOURCE)RESOURCES.map().tryGet(k);
/*  74 */           if (res == null) {
/*  75 */             GAME.WarnLight(j.errorGet("No resource with this key! ", k)); continue;
/*     */           } 
/*  77 */           int am = j.i(k, 1, 15);
/*     */           
/*  79 */           if (this.ramounts[res.index()] == 0) {
/*  80 */             resses.add(res);
/*     */           }
/*  82 */           if (am > this.ramounts[res.index()]) {
/*  83 */             this.ramounts[res.index()] = am;
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/*     */     
/*  92 */     if (resses.size() > 8) {
/*  93 */       json.error("Only 8 distinct resources are allowed", "");
/*     */     }
/*     */     
/*  96 */     ArrayList<RES_AMOUNT> ams = new ArrayList(resses.size());
/*  97 */     int tot = 0;
/*  98 */     for (int ri = 0; ri < resses.size(); ri++) {
/*  99 */       ams.add(new RES_AMOUNT.Abs((RESOURCE)resses.get(ri), this.ramounts[((RESOURCE)resses.get(ri)).index()]));
/* 100 */       tot += this.ramounts[((RESOURCE)resses.get(ri)).index()];
/*     */     } 
/*     */     
/* 103 */     this.amounts = (LIST<RES_AMOUNT>)ams;
/* 104 */     this.amountTotal = tot;
/*     */     
/* 106 */     this.bedTop = new RaceHomeSheet(this.amounts, json, "BED_1x1_TOP", (SheetType)SheetType.s1x1);
/* 107 */     this.bedBottom = new RaceHomeSheet(this.amounts, json, "BED_1x1_BOTTOM", (SheetType)SheetType.s1x1);
/* 108 */     this.carpet = new RaceHomeSheet(this.amounts, json, "CARPET_COMBO", (SheetType)SheetType.sCombo);
/* 109 */     this.table = new RaceHomeSheet(this.amounts, json, "TABLE_COMBO", (SheetType)SheetType.sCombo);
/* 110 */     this.nightStand = new RaceHomeSheet(this.amounts, json, "NIGHTSTAND_1x1", (SheetType)SheetType.s1x1);
/* 111 */     this.storage = new RaceHomeSheet(this.amounts, json, "STORAGE_1x1", (SheetType)SheetType.s1x1);
/* 112 */     this.chair = new RaceHomeSheet(this.amounts, json, "CHAIR_1x1", (SheetType)SheetType.s1x1);
/* 113 */     this.nick1 = new RaceHomeSheet(this.amounts, json, "NICKNACK_A_1x1", (SheetType)SheetType.s1x1);
/* 114 */     this.nickTop1 = new RaceHomeSheet(this.amounts, json, "NICKNACK_A_ONTOP_1x1", (SheetType)SheetType.s1x1);
/* 115 */     this.nick2 = new RaceHomeSheet(this.amounts, json, "NICKNACK_B_1x1", (SheetType)SheetType.s1x1);
/* 116 */     this.mat = new RaceHomeSheet(this.amounts, json, "MAT_1x1", (SheetType)SheetType.s1x1);
/* 117 */     this.masterBed = new RaceHomeSheet(this.amounts, json, "BED_MASTER_2x2", (SheetType)SheetType.s2x2);
/* 118 */     this.statue = new RaceHomeSheet(this.amounts, json, "STATUE_2x2", (SheetType)SheetType.s2x2);
/*     */     
/* 120 */     if (json.has("FLOORS")) {
/* 121 */       Json[] jsons = json.jsons("FLOORS");
/* 122 */       this.floors = new Floors.Floor[jsons.length];
/* 123 */       this.fneeded = Alloc.i2(jsons.length, ams.size());
/*     */       
/* 125 */       for (int i = 0; i < jsons.length; i++) {
/* 126 */         Json j = jsons[i];
/* 127 */         RaceHomeSheet.addResource((LIST<RES_AMOUNT>)ams, j, i, this.fneeded);
/* 128 */         this.floors[i] = (Floors.Floor)(SETT.FLOOR()).map.read(j);
/*     */       } 
/*     */     } else {
/* 131 */       this.floors = new Floors.Floor[0];
/* 132 */       this.fneeded = Alloc.i2(0, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<RES_AMOUNT> resources() {
/* 139 */     return this.amounts;
/*     */   }
/*     */   
/*     */   public int amount(RESOURCE res) {
/* 143 */     return this.ramounts[res.index()];
/*     */   }
/*     */   
/*     */   public int amountTotal() {
/* 147 */     return this.amountTotal;
/*     */   }
/*     */ 
/*     */   
/*     */   public Floors.Floor floor(HOME data) {
/* 152 */     for (int ai = this.floors.length - 1; ai >= 0; ai--) {
/* 153 */       int[] amounts = this.fneeded[ai];
/* 154 */       int i = 0; while (true) { if (i >= amounts.length)
/*     */         {
/*     */ 
/*     */           
/* 158 */           return this.floors[ai]; }  if (data.resourceAm(i) < amounts[i])
/*     */           break;  i++; } 
/* 160 */     }  return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\home\RaceHomeClass.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */