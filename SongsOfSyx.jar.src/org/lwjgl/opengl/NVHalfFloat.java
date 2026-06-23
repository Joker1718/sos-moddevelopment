/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NVHalfFloat
/*     */ {
/*     */   public static final int GL_HALF_FLOAT_NV = 5131;
/*     */   
/*     */   static {
/*  18 */     GL.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   protected NVHalfFloat() {
/*  23 */     throw new UnsupportedOperationException();
/*     */   }
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
/*     */   public static void glVertex2hvNV(@NativeType("GLhalfNV const *") ShortBuffer v) {
/*  38 */     if (Checks.CHECKS) {
/*  39 */       Checks.check(v, 2);
/*     */     }
/*  41 */     nglVertex2hvNV(MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glVertex3hvNV(@NativeType("GLhalfNV const *") ShortBuffer v) {
/*  56 */     if (Checks.CHECKS) {
/*  57 */       Checks.check(v, 3);
/*     */     }
/*  59 */     nglVertex3hvNV(MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glVertex4hvNV(@NativeType("GLhalfNV const *") ShortBuffer v) {
/*  74 */     if (Checks.CHECKS) {
/*  75 */       Checks.check(v, 4);
/*     */     }
/*  77 */     nglVertex4hvNV(MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glNormal3hvNV(@NativeType("GLhalfNV const *") ShortBuffer v) {
/*  92 */     if (Checks.CHECKS) {
/*  93 */       Checks.check(v, 3);
/*     */     }
/*  95 */     nglNormal3hvNV(MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glColor3hvNV(@NativeType("GLhalfNV const *") ShortBuffer v) {
/* 110 */     if (Checks.CHECKS) {
/* 111 */       Checks.check(v, 3);
/*     */     }
/* 113 */     nglColor3hvNV(MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glColor4hvNV(@NativeType("GLhalfNV const *") ShortBuffer v) {
/* 128 */     if (Checks.CHECKS) {
/* 129 */       Checks.check(v, 4);
/*     */     }
/* 131 */     nglColor4hvNV(MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glTexCoord1hvNV(@NativeType("GLhalfNV const *") ShortBuffer v) {
/* 146 */     if (Checks.CHECKS) {
/* 147 */       Checks.check(v, 1);
/*     */     }
/* 149 */     nglTexCoord1hvNV(MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glTexCoord2hvNV(@NativeType("GLhalfNV const *") ShortBuffer v) {
/* 164 */     if (Checks.CHECKS) {
/* 165 */       Checks.check(v, 2);
/*     */     }
/* 167 */     nglTexCoord2hvNV(MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glTexCoord3hvNV(@NativeType("GLhalfNV const *") ShortBuffer v) {
/* 182 */     if (Checks.CHECKS) {
/* 183 */       Checks.check(v, 3);
/*     */     }
/* 185 */     nglTexCoord3hvNV(MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glTexCoord4hvNV(@NativeType("GLhalfNV const *") ShortBuffer v) {
/* 200 */     if (Checks.CHECKS) {
/* 201 */       Checks.check(v, 4);
/*     */     }
/* 203 */     nglTexCoord4hvNV(MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glMultiTexCoord1hvNV(@NativeType("GLenum") int target, @NativeType("GLhalfNV const *") ShortBuffer v) {
/* 218 */     if (Checks.CHECKS) {
/* 219 */       Checks.check(v, 1);
/*     */     }
/* 221 */     nglMultiTexCoord1hvNV(target, MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glMultiTexCoord2hvNV(@NativeType("GLenum") int target, @NativeType("GLhalfNV const *") ShortBuffer v) {
/* 236 */     if (Checks.CHECKS) {
/* 237 */       Checks.check(v, 2);
/*     */     }
/* 239 */     nglMultiTexCoord2hvNV(target, MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glMultiTexCoord3hvNV(@NativeType("GLenum") int target, @NativeType("GLhalfNV const *") ShortBuffer v) {
/* 254 */     if (Checks.CHECKS) {
/* 255 */       Checks.check(v, 3);
/*     */     }
/* 257 */     nglMultiTexCoord3hvNV(target, MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glMultiTexCoord4hvNV(@NativeType("GLenum") int target, @NativeType("GLhalfNV const *") ShortBuffer v) {
/* 272 */     if (Checks.CHECKS) {
/* 273 */       Checks.check(v, 4);
/*     */     }
/* 275 */     nglMultiTexCoord4hvNV(target, MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glFogCoordhvNV(@NativeType("GLhalfNV const *") ShortBuffer fog) {
/* 290 */     if (Checks.CHECKS) {
/* 291 */       Checks.check(fog, 1);
/*     */     }
/* 293 */     nglFogCoordhvNV(MemoryUtil.memAddress(fog));
/*     */   }
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
/*     */   public static void glSecondaryColor3hvNV(@NativeType("GLhalfNV const *") ShortBuffer v) {
/* 308 */     if (Checks.CHECKS) {
/* 309 */       Checks.check(v, 3);
/*     */     }
/* 311 */     nglSecondaryColor3hvNV(MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glVertexWeighthvNV(@NativeType("GLhalfNV const *") ShortBuffer weight) {
/* 326 */     if (Checks.CHECKS) {
/* 327 */       Checks.check(weight, 1);
/*     */     }
/* 329 */     nglVertexWeighthvNV(MemoryUtil.memAddress(weight));
/*     */   }
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
/*     */   public static void glVertexAttrib1hvNV(@NativeType("GLuint") int index, @NativeType("GLhalfNV const *") ShortBuffer v) {
/* 344 */     if (Checks.CHECKS) {
/* 345 */       Checks.check(v, 1);
/*     */     }
/* 347 */     nglVertexAttrib1hvNV(index, MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glVertexAttrib2hvNV(@NativeType("GLuint") int index, @NativeType("GLhalfNV const *") ShortBuffer v) {
/* 362 */     if (Checks.CHECKS) {
/* 363 */       Checks.check(v, 2);
/*     */     }
/* 365 */     nglVertexAttrib2hvNV(index, MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glVertexAttrib3hvNV(@NativeType("GLuint") int index, @NativeType("GLhalfNV const *") ShortBuffer v) {
/* 380 */     if (Checks.CHECKS) {
/* 381 */       Checks.check(v, 3);
/*     */     }
/* 383 */     nglVertexAttrib3hvNV(index, MemoryUtil.memAddress(v));
/*     */   }
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
/*     */   public static void glVertexAttrib4hvNV(@NativeType("GLuint") int index, @NativeType("GLhalfNV const *") ShortBuffer v) {
/* 398 */     if (Checks.CHECKS) {
/* 399 */       Checks.check(v, 4);
/*     */     }
/* 401 */     nglVertexAttrib4hvNV(index, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribs1hvNV(@NativeType("GLuint") int index, @NativeType("GLhalfNV const *") ShortBuffer v) {
/* 411 */     nglVertexAttribs1hvNV(index, v.remaining(), MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribs2hvNV(@NativeType("GLuint") int index, @NativeType("GLhalfNV const *") ShortBuffer v) {
/* 421 */     nglVertexAttribs2hvNV(index, v.remaining() >> 1, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribs3hvNV(@NativeType("GLuint") int index, @NativeType("GLhalfNV const *") ShortBuffer v) {
/* 431 */     nglVertexAttribs3hvNV(index, v.remaining() / 3, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void glVertexAttribs4hvNV(@NativeType("GLuint") int index, @NativeType("GLhalfNV const *") ShortBuffer v) {
/* 441 */     nglVertexAttribs4hvNV(index, v.remaining() >> 2, MemoryUtil.memAddress(v));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertex2hvNV(@NativeType("GLhalfNV const *") short[] v) {
/* 446 */     long __functionAddress = (GL.getICD()).glVertex2hvNV;
/* 447 */     if (Checks.CHECKS) {
/* 448 */       Checks.check(__functionAddress);
/* 449 */       Checks.check(v, 2);
/*     */     } 
/* 451 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertex3hvNV(@NativeType("GLhalfNV const *") short[] v) {
/* 456 */     long __functionAddress = (GL.getICD()).glVertex3hvNV;
/* 457 */     if (Checks.CHECKS) {
/* 458 */       Checks.check(__functionAddress);
/* 459 */       Checks.check(v, 3);
/*     */     } 
/* 461 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertex4hvNV(@NativeType("GLhalfNV const *") short[] v) {
/* 466 */     long __functionAddress = (GL.getICD()).glVertex4hvNV;
/* 467 */     if (Checks.CHECKS) {
/* 468 */       Checks.check(__functionAddress);
/* 469 */       Checks.check(v, 4);
/*     */     } 
/* 471 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glNormal3hvNV(@NativeType("GLhalfNV const *") short[] v) {
/* 476 */     long __functionAddress = (GL.getICD()).glNormal3hvNV;
/* 477 */     if (Checks.CHECKS) {
/* 478 */       Checks.check(__functionAddress);
/* 479 */       Checks.check(v, 3);
/*     */     } 
/* 481 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColor3hvNV(@NativeType("GLhalfNV const *") short[] v) {
/* 486 */     long __functionAddress = (GL.getICD()).glColor3hvNV;
/* 487 */     if (Checks.CHECKS) {
/* 488 */       Checks.check(__functionAddress);
/* 489 */       Checks.check(v, 3);
/*     */     } 
/* 491 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glColor4hvNV(@NativeType("GLhalfNV const *") short[] v) {
/* 496 */     long __functionAddress = (GL.getICD()).glColor4hvNV;
/* 497 */     if (Checks.CHECKS) {
/* 498 */       Checks.check(__functionAddress);
/* 499 */       Checks.check(v, 4);
/*     */     } 
/* 501 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoord1hvNV(@NativeType("GLhalfNV const *") short[] v) {
/* 506 */     long __functionAddress = (GL.getICD()).glTexCoord1hvNV;
/* 507 */     if (Checks.CHECKS) {
/* 508 */       Checks.check(__functionAddress);
/* 509 */       Checks.check(v, 1);
/*     */     } 
/* 511 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoord2hvNV(@NativeType("GLhalfNV const *") short[] v) {
/* 516 */     long __functionAddress = (GL.getICD()).glTexCoord2hvNV;
/* 517 */     if (Checks.CHECKS) {
/* 518 */       Checks.check(__functionAddress);
/* 519 */       Checks.check(v, 2);
/*     */     } 
/* 521 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoord3hvNV(@NativeType("GLhalfNV const *") short[] v) {
/* 526 */     long __functionAddress = (GL.getICD()).glTexCoord3hvNV;
/* 527 */     if (Checks.CHECKS) {
/* 528 */       Checks.check(__functionAddress);
/* 529 */       Checks.check(v, 3);
/*     */     } 
/* 531 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glTexCoord4hvNV(@NativeType("GLhalfNV const *") short[] v) {
/* 536 */     long __functionAddress = (GL.getICD()).glTexCoord4hvNV;
/* 537 */     if (Checks.CHECKS) {
/* 538 */       Checks.check(__functionAddress);
/* 539 */       Checks.check(v, 4);
/*     */     } 
/* 541 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord1hvNV(@NativeType("GLenum") int target, @NativeType("GLhalfNV const *") short[] v) {
/* 546 */     long __functionAddress = (GL.getICD()).glMultiTexCoord1hvNV;
/* 547 */     if (Checks.CHECKS) {
/* 548 */       Checks.check(__functionAddress);
/* 549 */       Checks.check(v, 1);
/*     */     } 
/* 551 */     JNI.callPV(target, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord2hvNV(@NativeType("GLenum") int target, @NativeType("GLhalfNV const *") short[] v) {
/* 556 */     long __functionAddress = (GL.getICD()).glMultiTexCoord2hvNV;
/* 557 */     if (Checks.CHECKS) {
/* 558 */       Checks.check(__functionAddress);
/* 559 */       Checks.check(v, 2);
/*     */     } 
/* 561 */     JNI.callPV(target, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord3hvNV(@NativeType("GLenum") int target, @NativeType("GLhalfNV const *") short[] v) {
/* 566 */     long __functionAddress = (GL.getICD()).glMultiTexCoord3hvNV;
/* 567 */     if (Checks.CHECKS) {
/* 568 */       Checks.check(__functionAddress);
/* 569 */       Checks.check(v, 3);
/*     */     } 
/* 571 */     JNI.callPV(target, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glMultiTexCoord4hvNV(@NativeType("GLenum") int target, @NativeType("GLhalfNV const *") short[] v) {
/* 576 */     long __functionAddress = (GL.getICD()).glMultiTexCoord4hvNV;
/* 577 */     if (Checks.CHECKS) {
/* 578 */       Checks.check(__functionAddress);
/* 579 */       Checks.check(v, 4);
/*     */     } 
/* 581 */     JNI.callPV(target, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glFogCoordhvNV(@NativeType("GLhalfNV const *") short[] fog) {
/* 586 */     long __functionAddress = (GL.getICD()).glFogCoordhvNV;
/* 587 */     if (Checks.CHECKS) {
/* 588 */       Checks.check(__functionAddress);
/* 589 */       Checks.check(fog, 1);
/*     */     } 
/* 591 */     JNI.callPV(fog, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glSecondaryColor3hvNV(@NativeType("GLhalfNV const *") short[] v) {
/* 596 */     long __functionAddress = (GL.getICD()).glSecondaryColor3hvNV;
/* 597 */     if (Checks.CHECKS) {
/* 598 */       Checks.check(__functionAddress);
/* 599 */       Checks.check(v, 3);
/*     */     } 
/* 601 */     JNI.callPV(v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexWeighthvNV(@NativeType("GLhalfNV const *") short[] weight) {
/* 606 */     long __functionAddress = (GL.getICD()).glVertexWeighthvNV;
/* 607 */     if (Checks.CHECKS) {
/* 608 */       Checks.check(__functionAddress);
/* 609 */       Checks.check(weight, 1);
/*     */     } 
/* 611 */     JNI.callPV(weight, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib1hvNV(@NativeType("GLuint") int index, @NativeType("GLhalfNV const *") short[] v) {
/* 616 */     long __functionAddress = (GL.getICD()).glVertexAttrib1hvNV;
/* 617 */     if (Checks.CHECKS) {
/* 618 */       Checks.check(__functionAddress);
/* 619 */       Checks.check(v, 1);
/*     */     } 
/* 621 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib2hvNV(@NativeType("GLuint") int index, @NativeType("GLhalfNV const *") short[] v) {
/* 626 */     long __functionAddress = (GL.getICD()).glVertexAttrib2hvNV;
/* 627 */     if (Checks.CHECKS) {
/* 628 */       Checks.check(__functionAddress);
/* 629 */       Checks.check(v, 2);
/*     */     } 
/* 631 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib3hvNV(@NativeType("GLuint") int index, @NativeType("GLhalfNV const *") short[] v) {
/* 636 */     long __functionAddress = (GL.getICD()).glVertexAttrib3hvNV;
/* 637 */     if (Checks.CHECKS) {
/* 638 */       Checks.check(__functionAddress);
/* 639 */       Checks.check(v, 3);
/*     */     } 
/* 641 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttrib4hvNV(@NativeType("GLuint") int index, @NativeType("GLhalfNV const *") short[] v) {
/* 646 */     long __functionAddress = (GL.getICD()).glVertexAttrib4hvNV;
/* 647 */     if (Checks.CHECKS) {
/* 648 */       Checks.check(__functionAddress);
/* 649 */       Checks.check(v, 4);
/*     */     } 
/* 651 */     JNI.callPV(index, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribs1hvNV(@NativeType("GLuint") int index, @NativeType("GLhalfNV const *") short[] v) {
/* 656 */     long __functionAddress = (GL.getICD()).glVertexAttribs1hvNV;
/* 657 */     if (Checks.CHECKS) {
/* 658 */       Checks.check(__functionAddress);
/*     */     }
/* 660 */     JNI.callPV(index, v.length, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribs2hvNV(@NativeType("GLuint") int index, @NativeType("GLhalfNV const *") short[] v) {
/* 665 */     long __functionAddress = (GL.getICD()).glVertexAttribs2hvNV;
/* 666 */     if (Checks.CHECKS) {
/* 667 */       Checks.check(__functionAddress);
/*     */     }
/* 669 */     JNI.callPV(index, v.length >> 1, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribs3hvNV(@NativeType("GLuint") int index, @NativeType("GLhalfNV const *") short[] v) {
/* 674 */     long __functionAddress = (GL.getICD()).glVertexAttribs3hvNV;
/* 675 */     if (Checks.CHECKS) {
/* 676 */       Checks.check(__functionAddress);
/*     */     }
/* 678 */     JNI.callPV(index, v.length / 3, v, __functionAddress);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void glVertexAttribs4hvNV(@NativeType("GLuint") int index, @NativeType("GLhalfNV const *") short[] v) {
/* 683 */     long __functionAddress = (GL.getICD()).glVertexAttribs4hvNV;
/* 684 */     if (Checks.CHECKS) {
/* 685 */       Checks.check(__functionAddress);
/*     */     }
/* 687 */     JNI.callPV(index, v.length >> 2, v, __functionAddress);
/*     */   }
/*     */   
/*     */   public static native void glVertex2hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2);
/*     */   
/*     */   public static native void nglVertex2hvNV(long paramLong);
/*     */   
/*     */   public static native void glVertex3hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3);
/*     */   
/*     */   public static native void nglVertex3hvNV(long paramLong);
/*     */   
/*     */   public static native void glVertex4hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3, @NativeType("GLhalfNV") short paramShort4);
/*     */   
/*     */   public static native void nglVertex4hvNV(long paramLong);
/*     */   
/*     */   public static native void glNormal3hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3);
/*     */   
/*     */   public static native void nglNormal3hvNV(long paramLong);
/*     */   
/*     */   public static native void glColor3hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3);
/*     */   
/*     */   public static native void nglColor3hvNV(long paramLong);
/*     */   
/*     */   public static native void glColor4hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3, @NativeType("GLhalfNV") short paramShort4);
/*     */   
/*     */   public static native void nglColor4hvNV(long paramLong);
/*     */   
/*     */   public static native void glTexCoord1hNV(@NativeType("GLhalfNV") short paramShort);
/*     */   
/*     */   public static native void nglTexCoord1hvNV(long paramLong);
/*     */   
/*     */   public static native void glTexCoord2hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2);
/*     */   
/*     */   public static native void nglTexCoord2hvNV(long paramLong);
/*     */   
/*     */   public static native void glTexCoord3hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3);
/*     */   
/*     */   public static native void nglTexCoord3hvNV(long paramLong);
/*     */   
/*     */   public static native void glTexCoord4hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3, @NativeType("GLhalfNV") short paramShort4);
/*     */   
/*     */   public static native void nglTexCoord4hvNV(long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord1hNV(@NativeType("GLenum") int paramInt, @NativeType("GLhalfNV") short paramShort);
/*     */   
/*     */   public static native void nglMultiTexCoord1hvNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord2hNV(@NativeType("GLenum") int paramInt, @NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2);
/*     */   
/*     */   public static native void nglMultiTexCoord2hvNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord3hNV(@NativeType("GLenum") int paramInt, @NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3);
/*     */   
/*     */   public static native void nglMultiTexCoord3hvNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glMultiTexCoord4hNV(@NativeType("GLenum") int paramInt, @NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3, @NativeType("GLhalfNV") short paramShort4);
/*     */   
/*     */   public static native void nglMultiTexCoord4hvNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glFogCoordhNV(@NativeType("GLhalfNV") short paramShort);
/*     */   
/*     */   public static native void nglFogCoordhvNV(long paramLong);
/*     */   
/*     */   public static native void glSecondaryColor3hNV(@NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3);
/*     */   
/*     */   public static native void nglSecondaryColor3hvNV(long paramLong);
/*     */   
/*     */   public static native void glVertexWeighthNV(@NativeType("GLhalfNV") short paramShort);
/*     */   
/*     */   public static native void nglVertexWeighthvNV(long paramLong);
/*     */   
/*     */   public static native void glVertexAttrib1hNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV") short paramShort);
/*     */   
/*     */   public static native void nglVertexAttrib1hvNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glVertexAttrib2hNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2);
/*     */   
/*     */   public static native void nglVertexAttrib2hvNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glVertexAttrib3hNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3);
/*     */   
/*     */   public static native void nglVertexAttrib3hvNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void glVertexAttrib4hNV(@NativeType("GLuint") int paramInt, @NativeType("GLhalfNV") short paramShort1, @NativeType("GLhalfNV") short paramShort2, @NativeType("GLhalfNV") short paramShort3, @NativeType("GLhalfNV") short paramShort4);
/*     */   
/*     */   public static native void nglVertexAttrib4hvNV(int paramInt, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribs1hvNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribs2hvNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribs3hvNV(int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nglVertexAttribs4hvNV(int paramInt1, int paramInt2, long paramLong);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\NVHalfFloat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */