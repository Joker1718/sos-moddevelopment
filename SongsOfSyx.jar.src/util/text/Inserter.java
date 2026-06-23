/*     */ package util.text;
/*     */ 
/*     */ import game.GAME;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StrInserter;
/*     */ import util.data.GETTER_TRANS;
/*     */ 
/*     */ public class Inserter<T>
/*     */ {
/*  13 */   public final ArrayListGrower<II> all = new ArrayListGrower();
/*  14 */   private final KeyMap.CharMap<II> map = new KeyMap.CharMap();
/*     */   
/*     */   private static int ranI;
/*     */   
/*     */   public Inserter() {}
/*     */   
/*     */   public Inserter(Inserter<T> ii, String prefix) {
/*  21 */     for (II i : ii.all);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract class II
/*     */     extends StrInserter<T>
/*     */   {
/*     */     public II(Inserter this$0, String key) {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: aload_1
/*     */       //   2: putfield this$0 : Lutil/text/Inserter;
/*     */       //   5: aload_0
/*     */       //   6: aload_2
/*     */       //   7: invokespecial <init> : (Ljava/lang/String;)V
/*     */       //   10: aload_1
/*     */       //   11: getfield all : Lsnake2d/util/sets/ArrayListGrower;
/*     */       //   14: aload_0
/*     */       //   15: invokevirtual add : (Ljava/lang/Object;)I
/*     */       //   18: pop
/*     */       //   19: aload_1
/*     */       //   20: getfield map : Lsnake2d/util/sets/KeyMap$CharMap;
/*     */       //   23: aload_2
/*     */       //   24: aload_0
/*     */       //   25: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)I
/*     */       //   28: pop
/*     */       //   29: return
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #39	-> 0
/*     */       //   #40	-> 5
/*     */       //   #41	-> 10
/*     */       //   #42	-> 19
/*     */       //   #43	-> 29
/*     */       // Local variable table:
/*     */       //   start	length	slot	name	descriptor
/*     */       //   0	30	0	this	Lutil/text/Inserter$II;
/*     */       //   0	30	2	key	Ljava/lang/String;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract void set(T param1T, Str param1Str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   private static long ran = RND.rInt();
/*     */   public static void setRandom(long ran) {
/*  53 */     ranI = 0;
/*  54 */     Inserter.ran = ran;
/*     */   }
/*     */   
/*     */   public int ran() {
/*  58 */     ran >>= ranI;
/*     */     
/*  60 */     ranI += 4;
/*  61 */     if (ranI >= 64)
/*  62 */       ranI = 0; 
/*  63 */     return (int)(ran & 0xFL);
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean ww = false;
/*     */   
/*     */   public void check(CharSequence str) {
/*  70 */     for (int ii = 0; ii < 100; ii++) {
/*  71 */       CharSequence s = Str.getInsert(str, ii);
/*  72 */       if (s == null)
/*     */         break; 
/*  74 */       if (!this.map.containsKey(s)) {
/*     */         
/*  76 */         GAME.WarnLight("missing insert: " + String.valueOf(s) + ", in text: " + String.valueOf(str));
/*  77 */         if (!ww) {
/*  78 */           ww = true;
/*  79 */           String v = "Available:" + System.lineSeparator();
/*  80 */           v = v + v;
/*  81 */           GAME.Warn(v);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public CharSequence[] check(CharSequence[] str) {
/*     */     byte b;
/*     */     int i;
/*     */     CharSequence[] arrayOfCharSequence;
/*  90 */     for (i = (arrayOfCharSequence = str).length, b = 0; b < i; ) { CharSequence cc = arrayOfCharSequence[b];
/*  91 */       check(cc); b++; }
/*  92 */      return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public <K> Inserter<T> join(Inserter<K> in, GETTER_TRANS<T, K> trans) {
/*  97 */     for (II ii : in.all) {
/*  98 */       join(ii, trans);
/*     */     }
/* 100 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <K> Inserter<T> join(II ii, GETTER_TRANS<T, K> trans) {
/* 111 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Inserter<T> join(Inserter<T> in) {
/* 116 */     for (II ii : in.all) {
/* 117 */       join(ii);
/*     */     }
/* 119 */     return this;
/*     */   }
/*     */   
/*     */   public Inserter<T> join(II ii) {
/* 123 */     this.map.put(ii.key, ii);
/* 124 */     this.all.add(ii);
/* 125 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(Str str, T i) {
/* 130 */     if (i == null) {
/*     */       return;
/*     */     }
/* 133 */     for (int ii = 0; ii < 100; ii++) {
/* 134 */       CharSequence s = Str.getInsert((CharSequence)str, ii);
/* 135 */       if (s == null)
/*     */         break; 
/* 137 */       II iii = (II)this.map.get(s);
/* 138 */       if (iii != null) {
/*     */         
/*     */         try {
/* 141 */           iii.insert(i, str);
/* 142 */         } catch (Exception e) {
/* 143 */           throw new RuntimeException("problems with insert " + iii.key, e);
/*     */         } 
/*     */         
/* 146 */         ii--;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\Inserter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */